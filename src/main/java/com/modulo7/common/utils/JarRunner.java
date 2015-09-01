package com.modulo7.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Helper method to load jar and run it
 */
public class JarRunner {

    private final Method entryPoint;

    public JarRunner(File jarFile) throws
            ClassNotFoundException,
            IOException,
            NoSuchMethodException {
        URL jarUrl = jarFile.toURI().toURL();
        URLClassLoader loader = URLClassLoader.newInstance(
                new URL[]{jarUrl});
        URL manifestUrl = loader.findResource("META-INF/MANIFEST.MF");
        String manifest = resourceToString(manifestUrl);
        Class<?> clazz = loader.loadClass(findMainClassName(manifest));
        entryPoint = clazz.getMethod("main", String[].class);
    }

    public void run(String[] argsToMain) throws
            IllegalAccessException,
            IllegalArgumentException,
            InvocationTargetException {
        entryPoint.invoke(null, (Object) argsToMain);
    }

    private static String resourceToString(URL url) throws IOException {
        InputStream contentStream = url.openStream();
        try {
            BufferedReader r = new BufferedReader(
                    new InputStreamReader(contentStream));
            StringBuilder sb = new StringBuilder();
            String line = null;
            do {
                line = r.readLine();
                if (line != null) {
                    sb.append(line).append('\n');
                }
            } while (line != null);
            return sb.toString();
        } finally {
            contentStream.close();
        }
    }

    private static String findMainClassName(String manifest) {
        Matcher m = MAIN_CLASS_PATTERN.matcher(manifest);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }

    private static final Pattern MAIN_CLASS_PATTERN =
            Pattern.compile("Main-Class: (.+)");
}
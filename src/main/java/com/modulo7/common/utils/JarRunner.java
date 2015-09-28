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
 *
 * This is used to run the audiveris jav
 */
public class JarRunner {

    // The method which acts as the entry point into the jar
    private final Method entryPoint;

    /**
     * Constructor for the jar runner class
     * @param jarFile
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws NoSuchMethodException
     */
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

    // Entry point to a jar class run
    public void run(String[] argsToMain) throws
            IllegalAccessException,
            IllegalArgumentException,
            InvocationTargetException {
        entryPoint.invoke(null, (Object) argsToMain);
    }

    /**
     * Method to consume a classpath resource as a string
     * @param url
     * @return
     * @throws IOException
     */
    private static String resourceToString(URL url) throws IOException {
        InputStream contentStream = url.openStream();
        try {
            BufferedReader r = new BufferedReader(
                    new InputStreamReader(contentStream));
            StringBuilder sb = new StringBuilder();
            String line;
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

    /**
     * Method to search for a class with the main method defined
     * @param manifest
     * @return
     */
    private static String findMainClassName(String manifest) {
        Matcher m = MAIN_CLASS_PATTERN.matcher(manifest);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }

    /**
     * A regurlar expression defined for the main class
     */
    private static final Pattern MAIN_CLASS_PATTERN =
            Pattern.compile("Main-Class: (.+)");
}
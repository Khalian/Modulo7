package com.modulo7.common.utils;

import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.file.SeekableInput;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.mapred.FsInput;
import org.apache.avro.reflect.ReflectDatumReader;
import org.apache.avro.reflect.ReflectDatumWriter;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by asanyal on 9/30/15.
 *
 * Utility methods for storing and retrieving objects from HDFS
 */
public class HDFSUtils {


    // Acquire the reflective schema from Modulo7 class
    private static final Schema schema = Song.getSongSchema();

    /**
     * Utility method to read from HDFS Store a Modulo7 song object
     *
     * @param path
     * @throws IOException
     */
    private Song m7HDFSRead(final String path) throws IOException {
        Path hdfsPath = new Path(path);
        Configuration config = new Configuration();
        SeekableInput input = new FsInput(hdfsPath, config);
        DatumReader<Song> reader = new ReflectDatumReader<>(Song.class);
        DataFileReader<Song> dataFileReader = new DataFileReader<>(input, reader);

        for (Song song : dataFileReader) {
            return song;
        }

        dataFileReader.close(); // also closes underlying FsInput

        return null;
    }

    /**
     * Writes a song object to HDFS store
     * @param song
     * @param dstPath
     */
    private void myHDFSWrite(final Song song, final String dstPath) throws IOException {

        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        ReflectDatumWriter<Song> reflectDatumWriter = new ReflectDatumWriter<>(Song.class);
        DataFileWriter<Song> dataFileWriter = new DataFileWriter<>(reflectDatumWriter);

        Path filePath = new Path(dstPath);
        OutputStream out = fs.create(filePath);

        DataFileWriter<Song> hdfsWriter = dataFileWriter.create(schema, out);
        hdfsWriter.append(song);

        hdfsWriter.close();
        out.close();
        dataFileWriter.close();
    }
}

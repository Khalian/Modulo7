package com.modulo7.common.utils;

import com.modulo7.musicstatmodels.representation.Song;
import org.apache.avro.Schema;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumReader;
import org.apache.avro.reflect.ReflectDatumWriter;

import java.io.File;
import java.io.IOException;

/**
 * Created by asanyal on 8/21/15.
 *
 * Avro utility class for serializing and deserializing
 * avro files given a schema
 */
public class AvroUtils {

    /**
     * Method to serialize a modulo7 object, the assumption is that each file
     * has exactly song object stored into it
     *
     * Prototype taken from :
     *
     * @param destinationFileName
     * @param song
     */
    public static void serialize(final String destinationFileName, final Song song) throws IOException {

        // Acquire the reflective schema from Modulo7 class
        final Schema schema= ReflectData.get().getSchema(Song.class);

        DatumWriter<Song> writer = new ReflectDatumWriter<>(Song.class);
        DataFileWriter<Song> fileWriter = new DataFileWriter<>(writer);

        fileWriter.setCodec(CodecFactory.deflateCodec(5));
        fileWriter.create(schema, new File(destinationFileName));

        fileWriter.append(song);
        fileWriter.close();
    }

    /**
     * Method to deserialize modulo7 object, the assumption is that each file
     * has exactly
     *
     * Returns a null object if no song objects are serialized in the file
     *
     * @param sourceFileName
     * @return
     */
    public static Song deserialize(final String sourceFileName) throws IOException {

        File sourceFile = new File(sourceFileName);

        DatumReader<Song> reader = new ReflectDatumReader<>(Song.class);
        DataFileReader<Song> dataFileReader = new DataFileReader<>(sourceFile, reader);

        /**
         * Since we have only one song object in the file as assumed we return that back
         */
        for (Song song : dataFileReader) {
            return song;
        }

        // Return null if nothing appears
        return null;
    }
}

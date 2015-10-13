package com.modulo7.common.utils;

import com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;
import com.modulo7.nlp.lyrics.Lyrics;
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
 *
 * These utils can be used for serializing and deserializing songs and independent lyrics
 * objects.
 *
 * Right now the utils use java reflection. This is because the models are not yet stable
 * by that I mean new elements can be inserted or removed dependent on design changes
 *
 * Once the models are considered relatively stable, I will remove the reflection to accomodate
 * a non code gen schema version of operation
 */
public class AvroUtils {

    // Acquire the reflective schema from Modulo7 class
    private static final Schema schema = Song.getSongSchema();

    /**
     * Method to serialize a modulo7 object, the assumption is that each file
     * has exactly song object stored into it
     *
     * @param destinationFileName
     * @param song
     */
    public static void serialize(final String destinationFileName, final Song song) throws Modulo7NoSuchFileOrDirectoryException {

        DatumWriter<Song> writer = new ReflectDatumWriter<>(Song.class);
        DataFileWriter<Song> fileWriter = new DataFileWriter<>(writer);

        fileWriter.setCodec(CodecFactory.deflateCodec(5));
        try {
            fileWriter.create(schema, new File(destinationFileName));
            fileWriter.append(song);
            fileWriter.close();
        } catch (IOException e) {
            throw new Modulo7NoSuchFileOrDirectoryException("Cant create file in location :" + destinationFileName);
        }
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
    public static Song deserialize(final String sourceFileName) throws Modulo7NoSuchFileOrDirectoryException {

        File sourceFile = new File(sourceFileName);

        DatumReader<Song> reader = new ReflectDatumReader<>(Song.class);
        DataFileReader<Song> dataFileReader;
        try {
            dataFileReader = new DataFileReader<>(sourceFile, reader);
        } catch (IOException e) {
            throw new Modulo7NoSuchFileOrDirectoryException("No such file" + sourceFileName);
        }

        /**
         * Since we have only one song object in the file as assumed we return that back
         */
        for (Song song : dataFileReader) {
            return song;
        }

        // Return null if nothing appears
        return null;
    }

    /**
     * Serialize an independent lyrics object
     *
     * @param destinationFileName
     * @param lyrics
     * @throws com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException
     */
    public static void serialize(final String destinationFileName, final Lyrics lyrics) throws Modulo7NoSuchFileOrDirectoryException {
        // Acquire the reflective schema from Modulo7 class
        final Schema schema= ReflectData.get().getSchema(Lyrics.class);

        DatumWriter<Lyrics> writer = new ReflectDatumWriter<>(Lyrics.class);
        DataFileWriter<Lyrics> fileWriter = new DataFileWriter<>(writer);

        fileWriter.setCodec(CodecFactory.deflateCodec(5));
        try {
            fileWriter.create(schema, new File(destinationFileName));
            fileWriter.append(lyrics);
            fileWriter.close();
        } catch (IOException e) {
            throw new Modulo7NoSuchFileOrDirectoryException("Cant create file in location :" + destinationFileName);
        }
    }

    /**
     * Deserializer for an independent lyrics object
     *
     * @param sourceFileName
     * @return
     * @throws com.modulo7.common.exceptions.Modulo7NoSuchFileOrDirectoryException
     */
    public static Lyrics deserializeLyricsObject(final String sourceFileName) throws Modulo7NoSuchFileOrDirectoryException {
        File sourceFile = new File(sourceFileName);

        DatumReader<Lyrics> reader = new ReflectDatumReader<>(Lyrics.class);
        DataFileReader<Lyrics> dataFileReader;
        try {
            dataFileReader = new DataFileReader<>(sourceFile, reader);
        } catch (IOException e) {
            throw new Modulo7NoSuchFileOrDirectoryException("No such file" + sourceFileName);
        }

        /**
         * Since we have only one song object in the file by design as assumed we return that back
         */
        for (Lyrics lyrics : dataFileReader) {
            return lyrics;
        }

        // Return null if nothing appears
        return null;
    }
}

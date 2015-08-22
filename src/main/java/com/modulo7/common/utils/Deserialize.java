package com.modulo7.common.utils;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;

import java.io.File;
import java.io.IOException;

/**
 * Created by samar on 8/21/15.
 */
public class Deserialize {
    public static void main(String[] args ) throws IOException{
        Schema schema = new Schema.Parser().parse(new File("musicFeatures.avsc"));
        GenericRecord mus = new GenericData.Record(schema);

        File file = new File("music2.avro");

        DatumReader<GenericRecord> datumReader = new GenericDatumReader<GenericRecord>(schema);
        DataFileReader<GenericRecord> dataFileReader = new DataFileReader<GenericRecord>(file, datumReader);

        while (dataFileReader.hasNext()){

            mus = dataFileReader.next();
            System.out.println(mus);

        }

    }
}

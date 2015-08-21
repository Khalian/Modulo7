package com.modulo7.common.utils;

/**
 * Created by samar on 8/18/15.
   Serialization of the object using Avro
 */
import java.io.File;
import java.io.IOException;

import java.lang.String;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;

public class Serialize {
   public static void main(String[] args ) throws IOException {
       Schema schema = new Schema.Parser().parse(new File("musicFeatures.avsc"));
       GenericRecord mus1 = new GenericData.Record(schema);
       mus1.put("pitch", 10.55f);
       mus1.put("scales", "scale_value");
       mus1.put("modes", "modeValue");
       mus1.put("consonance", "consonance_value");
       mus1.put("rhythm","rhythm_value");
       mus1.put("melody","melody_value");

       GenericRecord mus2 = new GenericData.Record(schema);
       mus2.put("pitch", 11.55f);
       mus2.put("scales", "scale_value");
       mus2.put("modes", "modeValue");
       mus2.put("consonance", "consonance_value");
       mus2.put("rhythm","rhythm_value");
       mus2.put("melody","melody_value");

       File file = new File("music2.avro");
       DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>(schema);
       DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter);
       dataFileWriter.create(schema, file);
       dataFileWriter.append(mus1);
       dataFileWriter.append(mus2);
       dataFileWriter.close();

   }
}

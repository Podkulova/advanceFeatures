package serialized;

import serialized.MySerializeClass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Serializace objektu do souboru a deserializace ze souboru
public class MainSerialization {

    public static void main(String[] args) throws Exception {

        // nutne je upravit si zde cestu dle adresaru ve vasem PC
        // pripadne operacniho systemu
        String filename = "C:/JavaIO/serializable/serialized.binary";
        // -------------------------

        MySerializeClass serializeClass = new MySerializeClass("Jiri", 44, "London" );
        serializeClass.getStrList().add("hodnota1");
        serializeClass.getStrList().add("hodnota2");
        serializeClass.getStrList().add("hodnota888");

        System.out.println("serialize object : "  + serializeClass);
        serialize(serializeClass, filename);


        MySerializeClass newClass = (MySerializeClass)deserialize(filename);
        System.out.println("deserialized object : "  + newClass);

    }

    // serializuje libovolny objekt ktery implementuje rozhrani Serialize
    public static void serialize(Object serializeClass, String filename) throws Exception{

        FileOutputStream fileOutputStream = new FileOutputStream(filename); // vytvarime file output stream - data se budou zapisouvat do souboru
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream); // objekt serializuje a zapisuje do fileOutStream
        outputStream.writeObject(serializeClass); // serializace objektu
        outputStream.flush(); // vyprazdneni bufferu do souboru
        outputStream.close(); // uzavreni proudu
        fileOutputStream.close(); // uzavreni proudu
    }

    public static Object deserialize(String filename) throws Exception{
        FileInputStream fileIn = null;
        ObjectInputStream in = null;
        try {
            fileIn = new FileInputStream(filename); // vstupni stream ze souboru
            in = new ObjectInputStream(fileIn); // deserializacni stream
            return in.readObject(); // deserializce
        }finally {
            in.close(); // uzavirani
            fileIn.close(); // uzavirani
        }
    }


}

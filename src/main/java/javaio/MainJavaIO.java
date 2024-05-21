package javaio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Ukazka Java IO - vstupne vystupni operace
public class MainJavaIO {

    // nutne je upravit si zde cestu dle adresaru ve vasem PC
    // pripadne operacniho systemu
    protected static final String C_ROOTDIR = "C:/JavaIO";

    public static void main(String[] args) throws Exception {

        // nektere metody nemusi projit
        // jsou zavisle na souborech ve vasem PC

        sysProperty();
        basicIOTest();
        renameTest();
        genFilesTest();
        PathTest();
        streamTest();
        streamTest02();
        streamTest03();
        testBufferFiles();
        testBufferFiles02();
        testChannel();
        testBufferMem();
        nioTest();
        nioMethodCallTest();
        exampleTest();

    }
    // **************** IO *******************************

    public static void sysProperty(){
        // pouzity system property
        // vraci data dle opreracniho systemu WIN, MAC, LINUX

        // https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html

        System.out.println(System.getProperty("file.separator")); // oddelovac cesty k soubopru
        System.out.println(System.getProperty("line.separator")); // oddelovac radku textu

        // deklarace cesty s promenou prostredi dle operacniho systemu
        //protected static final String C_ROOTDIR = "C:" + System.getProperty("file.separator") + "JavaIO";
    }

    public static void basicIOTest() throws Exception {

        File file = new File(C_ROOTDIR + "/textfile.txt"); // nemusi byt (txt)
        if (file.exists()) { // test existence
            System.out.println("file exists");
            file.delete(); // smazani
        } else {
            System.out.println("file NOT exists");
        }
        file.createNewFile(); // prejmenovani
    }

    public static void renameTest() throws Exception {

        // trida file popisuje soubor ktery muze a nemusi existovat
        File file = new File(C_ROOTDIR + "/textfile.txt");
        if (file.exists()) { // pokud existuje
            // trida file popisuje novy soubor
            File newFile = new File(C_ROOTDIR + "/textfile_new_name.txt");
            if (newFile.exists()) { // pokud existuje
                newFile.delete(); // mazeme novy pokud existuje
            }
            file.renameTo(newFile); // stary soubor prejmenujeme na novy
        }
    }

    public static void genFilesTest() throws Exception {
        // vytvorime 10 souboru - generujeme nazev
        for(Integer i = 1; i<11; i++){
            File file = new File(C_ROOTDIR + "/file_" + i + ".txt");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
        }
    }

    public static void PathTest() throws Exception {
        // PATH - informace o souboru
        Path path = Paths.get(C_ROOTDIR + "/new.jpg");
        System.out.println(path.getFileName()); // nazev
        System.out.println(path.getParent()); // adresar
        System.out.println(path.toString()); //
    }

     // **************** STREAM *******************************

    public static void streamTest() throws Exception {

        // vhodne pro praci s binarnim souborem

        FileInputStream in = null; // vstupni souborovy stream
        FileOutputStream out = null; // vystupni souborovy stream
        try{
            in = new FileInputStream(C_ROOTDIR + "/source.jpg"); // vytvoreni in strem s cestou ke zdrojovemu souboru
            out = new FileOutputStream(C_ROOTDIR + "/new.jpg"); // vytvoreni out strem s cetou k cilovamu souboru
            int c;
            while((c = in.read()) != -1){ // nacteme po jednotlivych byte
                out.write(c); // vypiseme byte
            }
        }finally {
            if(in !=null){
                in.close();
            }
            if(out !=null){
                out.close();
            }
        }
    }
    public static void streamTest02() throws Exception {

        // vhodne pro praci s textem cteme po znacich

        FileReader in = null;
        FileWriter out = null;
        try {
            in = new FileReader(C_ROOTDIR + "/user.txt");
            out = new FileWriter(C_ROOTDIR + "/user_output.txt");
            int nextChar;
            while ((nextChar = in.read()) != -1) {
                out.append((char) nextChar);
            }
        }finally {
            if(in !=null){
                in.close();
            }
            if(out !=null){
                out.close();
            }
        }
    }

    public static void streamTest03() throws Exception {

        // vhodne pro praci s textem cteme po znacich

        List<Integer> myBuffer = new ArrayList<>(); // muj vlastni buffer (neefektivni)
        FileReader in = null;
        try {
            in = new FileReader(C_ROOTDIR + "/user.txt");
            int nextChar;
            while ((nextChar = in.read()) != -1) {
                myBuffer.add(nextChar); // plnim vlastni buffer
                System.out.print(","  + nextChar);
            }
        }finally {
            if(in !=null){
                in.close();
            }
        }
    }

    public static void testBufferFiles() throws Exception{

        // cdeni pomoci bufferu - cteme text po radcich
        // pro text nejlepsi

        BufferedReader in = new BufferedReader(new FileReader(C_ROOTDIR + "/user.txt"));
        BufferedWriter out = new BufferedWriter(new FileWriter(C_ROOTDIR + "/user_out_buffer.txt"));

        String line; // radek textu
        while ((line = in.readLine()) != null) { // cteme radek textu
            out.write(line); // vypisujeme do vystupu
            out.newLine(); // vypis znaku novy radek
        }
        in.close();
        out.close();
    }
    public static void testBufferFiles02() throws Exception{

        // cdeni pomoci bufferu - cteme text po radcich
        // pro text nejlepsi

        BufferedReader in = new BufferedReader(new FileReader(C_ROOTDIR + "/user.txt"));
        String line; // radek textu
        while ((line = in.readLine()) != null) { // cteme radek textu
            System.out.println(line); // vypisujeme
       }
        in.close();
    }

    public static void testChannel() throws Exception{

        // kanály
        // pokud by se někdo chtěl dozvedet vice zak zde
        // https://www.baeldung.com/java-filechannel

        RandomAccessFile file = new RandomAccessFile(C_ROOTDIR + "/user.txt", "r");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        while (fileChannel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
            byteBuffer.clear();
        }
        file.close();
    }

    public static void testBufferMem() throws Exception{

        // Buffer = pametovy prostor ktery drzi data
        // v prikladu do nej zapiseme retezec a pak vypiseme buffer

        CharBuffer buffer = CharBuffer.allocate(8);
        String text = "sda";
        System.out.println("Input text: " + text);

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            buffer.put(c);
        }
        System.out.println("Position after data is written into buffer: " + Arrays.toString(buffer.array()));
    }


    // ****************** NIO ********************************************************************
    // IO = input output
    // NIO = rozsireni IO (Files)
    // velmi ulehcuje praci se soubory
    public static void nioTest() throws Exception{

        // doporucuji pouzivat metody tridy Files

        // trida Path definuje cestu k souboru
        Path path = Paths.get(C_ROOTDIR + "/data.txt");

        // mazeme soubor pokud existuje
        Files.deleteIfExists(path);
        // vytvarime soubor
        Files.createFile(path);

        // zapis do soubou 3x
        Files.write(path, "A long time ago in a galaxy far, far away....\n".getBytes(), StandardOpenOption.WRITE);
        Files.write(path, "in a galaxy far, \n".getBytes(), StandardOpenOption.APPEND);
        Files.write(path, "far away....\n".getBytes(), StandardOpenOption.APPEND);

        // cteme rady souboru do List
        List<String> fileLines = Files.readAllLines(path);

        for (String line : fileLines) {
            System.out.println(line); // vypisujeme radky
        }
    }

    public static void nioMethodCallTest() throws Exception{

        List<String> lines = new ArrayList<>();
        lines.add("prvni radek");
        lines.add("druhy radek");
        lines.add("posledni radek");

        fileOutput("_ABCD.TXT", lines);
    }

    public static void fileOutput(String filename, List<String> lines) throws Exception{

        Path path = Paths.get(C_ROOTDIR + "/" + filename);
        Files.deleteIfExists(path);
        Files.createFile(path);
        Files.write(path, "".getBytes(), StandardOpenOption.WRITE);
        for(String sLine : lines){
            Files.write(path, sLine.getBytes(), StandardOpenOption.APPEND);
            Files.write(path,"\n".getBytes(), StandardOpenOption.APPEND);
        }

    }

    public static void exampleTest() throws Exception{

        // precteni binarniho souboru do pole byte[]
        Path path = Paths.get(C_ROOTDIR + "/new.jpg");
        byte[] data = Files.readAllBytes(path);
        System.out.println("size is :" + data.length);

    }

}
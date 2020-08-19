package com.tarnet.nio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

@Data
@AllArgsConstructor
public class FileReader {
    private String path;

    @SneakyThrows
    public void scannerReadData() {
        // FileInputStream,FileReader
        File myFile = new File(this.path);
        Scanner myFileReader = new Scanner(myFile);
        while (myFileReader.hasNextLine()) {
            String line = myFileReader.nextLine();
            System.out.println(line);
        }
        myFileReader.close();
    }

    @SneakyThrows
    public void fileReaderReadData() {
        java.io.FileReader fr = null;
        try {
            fr = new java.io.FileReader(this.path);
            int i;
            while ((i = fr.read()) != -1) {
                System.out.println((char) i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null)
                fr.close();
        }
    }

    @SneakyThrows
    public void fileInputStreamNIOReadData() {
        FileInputStream fis = new FileInputStream(this.path);
        FileChannel fisChannel = fis.getChannel();

        ByteBuffer fileBuffer = ByteBuffer.allocate(1024);
        fisChannel.read(fileBuffer);
        fileBuffer.flip();
        Charset ascii = Charset.forName("US-ASCII"); // DECODING
        CharBuffer charBuffer = ascii.decode(fileBuffer); // COPYING DECODED DATA
        char[] chars = new char[charBuffer.limit()];
        charBuffer.get(chars);
        for(char c:chars){
            System.out.println(c);
        }

        fisChannel.close();
        fis.close();
    }
}

package com.tarnet.nio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.concurrent.Future;

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
        for (char c : chars) {
            System.out.println(c);
        }

        fisChannel.close();
        fis.close();
    }

    @SneakyThrows
    public void copyFileNIO(String destinationPath) {
        FileInputStream fis = new FileInputStream(this.path);
        FileChannel fisChannel = fis.getChannel();

        FileOutputStream fos = new FileOutputStream(destinationPath);
        FileChannel fosChannel = fos.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (fisChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            fosChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        fosChannel.close();
        fisChannel.close();
        fos.close();
        fis.close();
    }

    @SneakyThrows
    public void asyncFileChannelReadData() {
        AsynchronousFileChannel asyncFileChannel = AsynchronousFileChannel.open(Paths.get(this.path),StandardOpenOption.READ);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        Future<Integer> readOperation= asyncFileChannel.read(byteBuffer,0);
        // OTHER OPERATION CAN BEE DONE HERE
        while(!readOperation.isDone());
        byteBuffer.flip();
        byte[] data = new byte[byteBuffer.limit()];
        byteBuffer.get(data);
        System.out.println(new String(data));
        byteBuffer.clear();
        asyncFileChannel.close();

    }

    @SneakyThrows
    public void asyncFileChannelReadData2() {
        AsynchronousFileChannel asyncFileChannel = AsynchronousFileChannel.open(Paths.get(this.path),StandardOpenOption.READ);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        asyncFileChannel.read(byteBuffer, 0, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println(result);
                attachment.flip();
                byte[] data = new byte[byteBuffer.limit()];
                byteBuffer.get(data);
                System.out.println(new String(data));
                attachment.clear();
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println(exc.getMessage());
            }
        });
        // OTHER OPERATION CAN BEE DONE HERE
//        while(!readOperation.isDone());
        while(true);
    }
}

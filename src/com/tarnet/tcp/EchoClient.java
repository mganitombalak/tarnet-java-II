package com.tarnet.tcp;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class EchoClient {
    @SneakyThrows
    public static void main(String[] args) {
        AsynchronousSocketChannel clientSocketChannel= AsynchronousSocketChannel.open();
        Future f = clientSocketChannel.connect(new InetSocketAddress("localhost",81));
        // Run(f);

        f.get();
        String str= "Hello! How are you?";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes());
        Future<Integer> writeOperation = clientSocketChannel.write(buffer);
        System.out.println("Writing to server: "+str);
        writeOperation.get();
        buffer.clear();
        Future<Integer> readOperation=clientSocketChannel.read(buffer);
        readOperation.get();
        buffer.flip();
        byte[] stringData = new byte[buffer.limit()];
        buffer.get(stringData);
        System.out.println(new String("Server says:"+ stringData));
        clientSocketChannel.close();
//        buffer.flip();
//        Future<Integer> readval = client.read(buffer);
//        System.out.println("Received from server: "
//                +new String(buffer.array()).trim());
//        readval.get();
//        buffer.clear();
    }
}

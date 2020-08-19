package com.tarnet.tcp;

import lombok.SneakyThrows;

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
        AsynchronousSocketChannel client= AsynchronousSocketChannel.open();
        Future f = client.connect(new InetSocketAddress("localhost",81));
        // Run(f);

        AsynchronousSocketChannel socketChannel = (AsynchronousSocketChannel) f.get();
        String str= "Hello! How are you?";
        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
        Future<Integer> writeOperation = client.write(buffer);
        System.out.println("Writing to server: "+str);
        writeOperation.get();
//        buffer.flip();
//        Future<Integer> readval = client.read(buffer);
//        System.out.println("Received from server: "
//                +new String(buffer.array()).trim());
//        readval.get();
//        buffer.clear();
    }
}

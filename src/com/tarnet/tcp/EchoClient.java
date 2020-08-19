package com.tarnet.tcp;

import lombok.SneakyThrows;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class EchoClient {


    @SneakyThrows
    public static void main(String[] args) {
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        Future future = client.connect(new InetSocketAddress("localhost", 81));
        future.get();
        String result = sendMsg("deneme", client);
        System.out.println(result);
    }




    public static String sendMsg(String message, AsynchronousSocketChannel client) throws ExecutionException, InterruptedException {
        byte[] byteMsg = new String(message).getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Future<Integer> writeResult = client.write(buffer);
        writeResult.get();
        buffer.flip();
        Future<Integer> readResult = client.read(buffer);
        readResult.get();
        String echo = new String(buffer.array()).trim();
        buffer.clear();
        buffer.get(byteMsg);
        return echo;
    }
}

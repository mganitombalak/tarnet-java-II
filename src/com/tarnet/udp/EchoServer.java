package com.tarnet.udp;

import lombok.SneakyThrows;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class EchoServer {
    @SneakyThrows
    public static void main(String[] args) {
        //DATAGRAM echoServer = AsynchronousServerSocketChannel.open();
        echoServer.bind(new InetSocketAddress("127.0.0.1", 81));
        Future<AsynchronousSocketChannel> f = echoServer.accept();
        Run(f);
    }

    @SneakyThrows
    public static void Run(Future<AsynchronousSocketChannel> channelFuture) {
        AsynchronousSocketChannel socketChannel = channelFuture.get();

        while (true) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(128);
            Future<Integer> readOperation = socketChannel.read(byteBuffer);
            // OTHER OPERATIONS
            readOperation.get();
            byteBuffer.flip();
            Future<Integer> writeOperation = socketChannel.write(byteBuffer);
            // OTHER OPERATIONS

            writeOperation.get();
            byteBuffer.clear();
        }
    }
}

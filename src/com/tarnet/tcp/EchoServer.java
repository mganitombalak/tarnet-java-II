package com.tarnet.tcp;

import lombok.SneakyThrows;
import lombok.var;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class EchoServer {
    @SneakyThrows
    public static void main(String[] args) {
        AsynchronousServerSocketChannel echoServer = AsynchronousServerSocketChannel.open();
        echoServer.bind(new InetSocketAddress("127.0.0.1", 81));
        Future<AsynchronousSocketChannel> f = echoServer.accept();
        Run(f);
        // echoServer.close();
    }

    @SneakyThrows
    public static void Run(Future<AsynchronousSocketChannel> channelFuture) {
        AsynchronousSocketChannel socketChannel = channelFuture.get();

        if ((socketChannel == null) || (!socketChannel.isOpen())) {
            System.out.println("kapalı connection");
            return;
        }

        while (true) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            Future<Integer> readOperation = socketChannel.read(byteBuffer);

            System.out.println("Received from client: "
                    + new String(byteBuffer.array()).trim());

            if (byteBuffer.position() == 0) continue;

            readOperation.get();
            byteBuffer.flip();

            String str= "I'm fine";
            Future<Integer> writeOperation = socketChannel.write(
                    ByteBuffer.wrap(str.getBytes()));
            System.out.println("Writing back to client: "
                    +str);
            writeOperation.get();

            byteBuffer.clear();
        }
//        socketChannel.close();
    }
}

package com.tarnet.tcp;

import lombok.SneakyThrows;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class EchoClient {
    @SneakyThrows
    public static void main(String[] args) {
        AsynchronousSocketChannel client= AsynchronousSocketChannel.open();
        Future f = client.connect(new InetSocketAddress("localhost",81));

    }
}

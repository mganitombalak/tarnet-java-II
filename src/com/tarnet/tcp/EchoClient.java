package com.tarnet.tcp;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class EchoClient {
    public static void main (String [] args)
            throws Exception {

        new EchoClient().go();
    }

    private void go()
            throws IOException, InterruptedException, ExecutionException {

        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        InetSocketAddress hostAddress = new InetSocketAddress("localhost", 3883);
        Future future = client.connect(hostAddress);
        future.get(); // returns null

        System.out.println("Client is started: " + client.isOpen());
        System.out.println("Sending messages to server: ");

        String [] messages = new String [] {"Time goes fast.", "What now?", "Bye."};

        for (int i = 0; i < messages.length; i++) {

            byte [] message = new String(messages [i]).getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(message);
            Future result = client.write(buffer);

            while (! result.isDone()) {
                System.out.println("... ");
            }

            System.out.println(messages [i]);
            buffer.clear();
            Thread.sleep(3000);
            readMessage(client);
        } // for

        client.close();
    }

    private void readMessage(AsynchronousSocketChannel clientChannel) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Future result = clientChannel.read(buffer);

        while (! result.isDone()) {
            // do nothing
        }

        buffer.flip();
        String message = new String(buffer.array());
        System.out.println(message);



        buffer.clear();
    }
}

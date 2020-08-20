package com.tarnet.tcp;

import lombok.SneakyThrows;
import lombok.var;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class EchoServer {
    public static void main (String [] args)
            throws Exception {

        new EchoServer().go();
    }

    private void go()
            throws IOException, InterruptedException, ExecutionException {

        AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open();
        InetSocketAddress hostAddress = new InetSocketAddress("localhost", 3883);
        serverChannel.bind(hostAddress);

        System.out.println("Server channel bound to port: " + hostAddress.getPort());
        System.out.println("Waiting for client to connect... ");

        Future acceptResult = serverChannel.accept();
        AsynchronousSocketChannel clientChannel = (AsynchronousSocketChannel) acceptResult.get();

        System.out.println("Messages from client: ");

        if ((clientChannel != null) && (clientChannel.isOpen())) {

            while (true) {

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                Future result = clientChannel.read(buffer);

                while (! result.isDone()) {
                    // do nothing
                }

                buffer.flip();
                String message = new String(buffer.array());
                System.out.println(message);

                if (message.equals("Bye.")) {

                    break; // while loop
                }

                buffer.clear();
                writeBack(clientChannel,message);

            } // while()

            clientChannel.close();

        } // end-if

        serverChannel.close();
    }

    private void writeBack(AsynchronousSocketChannel client, String messages) {
        byte [] message = new String(messages ).getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(message);
        Future result = client.write(buffer);

        while (! result.isDone()) {
            System.out.println("... ");
        }

        System.out.println(messages);
        buffer.clear();

    }
}

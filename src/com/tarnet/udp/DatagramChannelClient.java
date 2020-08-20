package com.tarnet.udp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelClient {
   public static void main(String[] args) throws IOException {
      DatagramChannel client = null;
      client = DatagramChannel.open();

      client.bind(null);

      String msg = "sa World!";
      ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
      InetSocketAddress serverAddress = new InetSocketAddress("localhost",
        82);

      client.send(buffer, serverAddress);
      buffer.clear();
      client.receive(buffer);
      buffer.flip();
      int limits = buffer.limit();
      byte bytes[] = new byte[limits];
      buffer.get(bytes, 0, limits);
       msg = new String(bytes);
      System.out.println("Server  sent: " + msg);
      client.close();
   }
}
package com.Test0628;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer2 {
    private DatagramSocket socket = null;

    public UdpEchoServer2(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {

            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            String request = new String(requestPacket.getData(),
                    0,requestPacket.getLength()).trim();

            String response = process(request);

            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,
                    requestPacket.getSocketAddress());
            socket.send(requestPacket);

            System.out.printf("[%s,%d]req:%s,resp:%s",requestPacket.getAddress().toString(),
                    responsePacket.getPort(),request,response);

        }

    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}

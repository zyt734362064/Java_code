package com.Test0630;

import com.Test0629.UdpEchoClient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true){
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            String requset = new String(requestPacket.getData(),0,
                    requestPacket.getLength()).trim();

            String response = process(requset);
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length,requestPacket.getSocketAddress());
            socket.send(responsePacket);

            System.out.printf("[%s:%d]req:%s;resp:%s\n",requestPacket.getAddress().toString(),
                    requestPacket.getPort(),requset,response);


        }


    }

    public  String process(String requset) {
        return requset;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}

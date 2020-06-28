package com.Test0628;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    //对与一个服务器来说，核心程序也是要分两步
    //1.进行初始化操作（实例化 Socket 对象）
    //2.进入主循环，接收并处理请求（主循环就是一个“死循环”）
    //1）读取数据并解析
    //2) 根据请求计算响应
    //3）把响应结果写回到服务端
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {    //port 就是端口号
        socket = new DatagramSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true){
            //1）读取数据并解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);//指定一个缓冲区
            socket.receive(requestPacket);
            String request = new String(requestPacket.getData(),0,requestPacket.getLength()).trim();
            //2) 根据请求计算响应
            String response = process(request);
            //3）把响应结果写回到服务端,相应数据就是 response,需要包装成一个 Packet 对象
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,
                    requestPacket.getSocketAddress());
            socket.send(responsePacket);

            //打印一条请求日志
            System.out.printf("[%s:%d] req: %s;resp: %s\n",requestPacket.getAddress().toString(),
                    requestPacket.getPort(),request,response);
        }
    }

    private String process(String request) {
        //此处是一个 echo server ，请求内容是啥，相应内容就是啥
        //如果是一个更复杂的服务器，此处就需要包含很多的业务逻辑来进行具体的计算
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}

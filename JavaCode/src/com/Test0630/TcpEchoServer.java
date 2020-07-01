package com.Test0630;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpEchoServer {
    //1.初始化服务器
    //2.进入主循环
    // 1）先去从内核中获取到一个 TCP 的连接
    // 2）处理这个 TCP 的连接
    //      a)读取请求并解析
    //      b)根据请求计算响应
    //      c)把响应写回到客户端
    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true){
            //1）先从内核中获取到一个 TCP 连接
            Socket clientSocket = serverSocket.accept();
            //2）处理这个连接
            processConnection(clientSocket);
        }
    }

    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d]客户端上线\n",clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        //通过 clientSocket来和客户端交互，先做好准备工作，获取到 clientSocket 中的流对象
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            //此处我们先实现一个长连接版本的服务器
            //一次连接的处理过程中，需要处理多个请求和响应
            //这个循环在客户端断开连接时就结束了
            //客户端断开连接时，服务器再去调用 readLine 或者write 方法都会触发异常
            while (true){
                //1.读取请求并解析(此处的 readLine 对应客户端发送数据的格式，必须按行发送）
                String request = bufferedReader.readLine();
                //2.根据请求计算响应
                String response = process(request);
                //3.把响应写回客户端(客户端需要按行来读）
                bufferedWriter.write(response + "\n");

                System.out.printf("[%s,%d]req:%s; resp:%s\n",clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(),request,response);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("[%s:%d]客户端下线\n",clientSocket.getInetAddress().toString(),
                    clientSocket.getPort());
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}

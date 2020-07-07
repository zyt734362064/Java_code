package com.Test0707;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Create with IntelliJ IDEA
 * Description:TCP 服务器
 * User:Zyt
 * Date:2020-07-07
 */
public class TcpEchoServer {
    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动！");
        while (true){
            Socket clientSocket = serverSocket.accept();

            processConnection(clientSocket);
        }
    }

    private void processConnection(Socket clientSocket) {
            System.out.printf("[%s:%d]客户端上线\n",clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter bufferedWriter =  new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))){
            while (true){
                String request = bufferedReader.readLine();
                String response = process(request);
                bufferedWriter.write(response + "\n");
                bufferedWriter.flush();
                System.out.printf("[%s:%d]req:%s,resp:%s\n",clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(),request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("[%s:%d]客户端下线\n",clientSocket.getInetAddress().toString(),
                    clientSocket.getPort());
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer tcpEchoServer = new TcpEchoServer(9090);
        tcpEchoServer.start();
    }
}

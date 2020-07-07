package com.Test0707;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Create with IntelliJ IDEA
 * Description:TCP 客户端
 * User:Zyt
 * Date:2020-07-07
 */
public class TcpEchoClient {
    private Socket socket = null;

    public TcpEchoClient(String serverIP,int serverPort) throws IOException {
        socket = new Socket(serverIP,serverPort);
    }
    public void start(){
        System.out.println("客户端启动！");
        Scanner scanner = new Scanner(System.in);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
            while (true){
                System.out.print("->");
                String request = scanner.nextLine();
                if (request.equals("exit")){
                    break;
                }
                bufferedWriter.write(request + "\n");
                bufferedWriter.flush();
                String response = bufferedReader.readLine();
                System.out.println(response);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1",9090);
        tcpEchoClient.start();
    }
}

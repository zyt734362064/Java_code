package com.Test0630;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UdpDicServer extends UdpEchoServer {

    private Map<String,String> dict = new HashMap<>();
    public UdpDicServer(int port) throws SocketException {
        super(port);
        dict.put("cat","小猫");
        dict.put("dog","小狗");
        dict.put("sheep","绵羊");
    }
    //重写 process 方法，需要将UdpEchoServer中的 process方法中的 private 改成 public
    @Override
    public String process(String requset) {
        return dict.getOrDefault(requset,"这超出了我的知识范围");
    }

    public static void main(String[] args) throws IOException {
        UdpDicServer server = new UdpDicServer(9090);
        server.start();
    }
}

package com.Test0628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private  String method;
    private String url;
    private String version;
    private Map<String,String> headers = new HashMap<>();
    private Map<String,String> parameters = new HashMap<>();
    private Map<String,String> cookies = new HashMap<>();
    private  String body;
    public static HttpRequest build(InputStream inputStream) throws IOException {
        HttpRequest request = new HttpRequest();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String firstLine = bufferedReader.readLine();
        String[] firstLineTokens = firstLine.split(" ");
        request.method = firstLineTokens[0];
        request.url = firstLineTokens[1];
        request.version = firstLineTokens[2];
        int pos = request.url.indexOf("?");
        if (pos != -1){
            String queryString = request.url.substring(pos + 1);
            parseKV(queryString,request,request.parameters);
        }
        String line = "";
        while ((line = bufferedReader.readLine()) != null && line.length() != 0){
            String[] headerTokens = line.split(":");
            request.headers.put(headerTokens[0],headerTokens[1]);
        }
        String cookie = request.headers.get("Cookie");
        if (cookie != null){
            parseCookie(cookie,request.cookies);
        }
        return request;
    }

    private static void parseCookie(String cookie, Map<String,String> cookies) {
        String[] kvTokens = cookie.split("");
    }

    private static void parseKV(String queryString, HttpRequest request, Map<String, String> parameters) {
        String[] kvTokens = queryString.split("&");
        for (String kv : kvTokens){

        }

    }
}

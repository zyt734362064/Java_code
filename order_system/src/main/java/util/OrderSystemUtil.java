package util;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;


/**
 * Create with IntelliJ IDEA
 * Description:需要实现读取 body 的功能
 * 需要把整个 body 读取出来，然后才能去解析 JSON
 * User:Zyt
 * Date:2020-08-15
 */
public class OrderSystemUtil {
    public static String readBody(HttpServletRequest request){
        //先获取到 body 的长度（单位为字节）
        int length = request.getContentLength();
        byte[] buffer = new byte[length];
        try (InputStream inputStream = request.getInputStream()){
            inputStream.read(buffer,0,length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //此处有一个重要的注意事项，构造 String 的时候，必须要指定
        //该字符串的编码方式，（这个操作相当于就是把字节数据转成字符数据
        //涉及到这样的转换，最好都加上编码方式
        //涉及到这样的转换，最好都加上编码方式
        return new String(buffer);
    }
}

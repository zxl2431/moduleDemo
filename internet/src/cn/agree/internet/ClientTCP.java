package cn.agree.internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientTCP {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端 发送数据");
        // 1.创建Socket(ip, port)
        Socket client = new Socket("localhost", 6666);
        // 2.获取流对象 输出流
        OutputStream os = client.getOutputStream();
        // 3.写出数据
        os.write("你好么? tcp, 我来了".getBytes());
        // ========== 解析回写 ==========
        InputStream in = client.getInputStream();
        byte[] bytes = new byte[1024];
        int len = in.read(bytes);
        System.out.println(new String(bytes, 0, len));
        // 4.关闭资源
        in.close();
        os.close();
        client.close();

    }
}

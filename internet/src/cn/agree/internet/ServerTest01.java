package cn.agree.internet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest01 {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动, 等待连接...");
        // 创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket socket = serverSocket.accept();
        // 转换流读取浏览器对象
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String request = bufferedReader.readLine();
        // 取出请求资源的路径
        String[] strArr = request.split(" ");
        // 去掉web前面的
        String path = strArr[1].substring(1);
        System.out.println(new String(path));
        // 读取客户请求的资源文件
        // FileInputStream fis = new FileInputStream(path);
        FileInputStream fis = new FileInputStream("E:/pic.jpg");
        byte[] bytes = new byte[1024];
        int len = 0;
        // 字节输出流 将文件写入客户端
        OutputStream out = socket.getOutputStream();
        // 写入HTTP协议响应头,固定写法
        out.write("HTTP/1.1 200 OK\r\n".getBytes());
        out.write("Content‐Type:text/html\r\n".getBytes());
        // 必须要写入空行,否则浏览器不解析
        out.write("\r\n".getBytes());

        // 开始网络传输
        while ((len = fis.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }



        //
        fis.close();
        out.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}

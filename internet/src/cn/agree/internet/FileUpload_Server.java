package cn.agree.internet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileUpload_Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器 启动...");
        ServerSocket serverSocket = new ServerSocket(6666);
        // 建立连接
        Socket accept = serverSocket.accept();
        // 读取client发送过来的文件
        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:/copy.jpg"));
        // 读取数据
        byte[] bytes = new byte[1024 * 8];
        int len;

        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        // 关闭资源
        bos.close();
        bis.close();
        accept.close();
        System.out.println("文件上传已保存");


    }
}

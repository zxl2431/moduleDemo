package cn.agree.internet;

import java.io.*;
import java.net.Socket;

public class FileUpload_Client {
    public static void main(String[] args) throws IOException {
        // 创建流对象
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:/pic.jpg"));
        // 这两句把socket的流绑定
        Socket socket = new Socket("localhost", 6666);
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        //
        byte[] bytes = new byte[1024 * 8];
        int len;
        while ((len = bis.read(bytes))!=-1) {
            bos.write(bytes, 0, len);
            bos.flush();
        }

        System.out.println("文件发送完毕");
        // 关闭资源
        bos.close();
        socket.close();
        bis.close();

    }
}

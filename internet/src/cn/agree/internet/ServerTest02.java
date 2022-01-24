package cn.agree.internet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ServerTest02 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            Socket socket = server.accept();
            new Thread(new Web(socket)).start();
        }
    }

    static class Web implements Runnable{
        private Socket socket;

        public Web(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader readWb = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = readWb.readLine();
                String[] strArr = request.split(" ");
                System.out.println(Arrays.toString(strArr));
                String path = strArr[1].substring(1);


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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

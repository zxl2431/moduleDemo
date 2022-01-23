package cn.agree.internet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileUpload_Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器 启动...");
        ServerSocket serverSocket = new ServerSocket(6666);

        // 每次接受新的连接,创建一个socket
        while (true) {
            // 建立连接
            Socket accept = serverSocket.accept();
            /*
            *  socket对象交给子线程处理 进行读写操作
            *
            * */
            new Thread(() -> {
                try(// 读取client发送过来的文件
                    BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:/" +
                            System.currentTimeMillis() + ".jpg"));) {

                    // 读取数据
                    byte[] bytes = new byte[1024 * 8];
                    int len;

                    while ((len = bis.read(bytes)) != -1) {
                        bos.write(bytes, 0, len);
                        // System.out.println(len);
                    }

                    // 信息回写
                    System.out.println("back......");
                    OutputStream out = accept.getOutputStream();
                    out.write("上传成功".getBytes());
                    out.close();

                    // 关闭资源
                    bos.close();
                    bis.close();
                    accept.close();
                    System.out.println("文件上传已保存");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}

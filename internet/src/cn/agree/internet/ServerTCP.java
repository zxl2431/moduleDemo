package cn.agree.internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动,等待连接...");
        // 1.创建 ServerSoctet对象,绑定端口,开始等待连接
        ServerSocket serverSocket = new ServerSocket(6666);
        // 2. 接受连接 accept 方法, 返回socket 对象
        Socket server = serverSocket.accept();
        // 3.通过socket 获取输入流
        InputStream is = server.getInputStream();
        // 4.读取数据
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        String msg = new String(bytes, 0, len);
        System.out.println(msg);
        // ======== 礼尚往来 回写数据 =======
        OutputStream out = server.getOutputStream();
        out.write("我还蛮好的,谢谢".getBytes());

        // 5.关闭资源
        out.close();
        is.close();
        server.close();


    }
}

package cn.agree.servlet;



import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;

@WebServlet(name = "DownloadServlet", urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 下载文件
        System.out.println("收到一个请求...");

        // 客户端携带过来的文件名就是请求参数, 请求参数封装request对象中
        String fileName = req.getParameter("fileName");
        System.out.println(fileName);

        // 在下载文件之前,要告诉客户端,弹出一个文件下载的提示框
        //通过设置一个名为“Content-Disposition”的响应头
        //响应头和请求头中都不能出现中
        //将中文进行编码,使用URLEncoder进行编码
        //获取到这个文件名之后，要将这个文件名拼接成文件路径
        String path ="D:/moduleDemo/artifacts/servlet_rsp_war_exploded/download/" + fileName;

        // URLEncoder编码的内容URLDecoder都能解码 处了火狐浏览器之外
        // 火狐浏览器用的是Base64的解码 所以针对火狐浏览器需要特殊处理
        // 判断是不是火狐浏览器
        String agent = req.getHeader("User-Agent");

        if (!agent.contains("Firefox")) {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            System.out.println("非火狐浏览器编码后的fileName:"+fileName);
        } else{
            fileName = base64Encode(fileName);
            System.out.println("火狐浏览器编码后的fileName:"+fileName);
        }

        //放在header中的应该是编码过后的字符串
        resp.setHeader("Content-Disposition","attachment;filename="+fileName);

        // 将文件转换成字节输入流
        InputStream in = new FileInputStream(path);

        //定义一个字节数组buffer
        byte[] buffer = new byte[1024];

        //获取一个字节输出流，这个输出流应该能将字节输出到客户端
        ServletOutputStream out = resp.getOutputStream();

        //定义一个标示，用来判断是否读写完了
        int len = 0;

        while((len = in.read(buffer)) != -1){
            //上述操作已经将in中的字节读取到buffer中
            //接下来就要将buffer中的使用out来写出去
            out.write(buffer,0,len);
        }
        out.close();
        in.close();

        // 输出流
        // ServletOutputStream out = resp.getOutputStream();
        // IOUtils


    }

    private String base64Encode(String fileName) throws UnsupportedEncodingException {
        Base64.Encoder encoder = Base64.getEncoder();
        fileName = encoder.encodeToString(fileName.getBytes("UTF-8"));
        fileName = "=?utf-8?B?" + fileName + "?=";
        return fileName;
    }
}

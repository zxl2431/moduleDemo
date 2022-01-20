package cn.agree.bytestream;

import java.io.*;
import java.util.HashMap;

public class BufferedTest01 {
    public static void main(String[] args) throws IOException {
        // 创建Map集合 键为序号
        HashMap<String, String> lineMap = new HashMap<>();

        // 创建流对象
        BufferedReader br = new BufferedReader(new FileReader("E:/in.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:/out.txt"));

        // 读取数据
        String line = null;
        while ((line = br.readLine()) != null) {
            // System.out.println(line);
            String[] split = line.split("\\.");
            // System.out.println(split[1]);
            lineMap.put(split[0], split[1]);
        }

        // 释放资源
        br.close();

        for (int i = 1; i < lineMap.size(); i++) {
            // int 转String
            String key = String.valueOf(i);
            // 获取map中文本
            String value = lineMap.get(key);
            // 拼接
            bw.write(key+"."+value);
            bw.newLine();
        }

        bw.close();


    }
}

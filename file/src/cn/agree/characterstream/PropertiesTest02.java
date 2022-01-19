package cn.agree.characterstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest02 {
    public static void main(String[] args) throws IOException {
        // 创建属性集对象
        Properties properties = new Properties();
        // 加载文本中信息到属性集
        properties.load(new FileReader("E:/properties.txt"));

        Set<String> strings = properties.stringPropertyNames();
        for (String key : strings) {
            System.out.println(key+"----------"+properties.getProperty(key));
        }

    }
}

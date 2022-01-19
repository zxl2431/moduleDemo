package cn.agree.characterstream;

import java.util.Properties;
import java.util.Set;

public class PropertiesTest01 {
    public static void main(String[] args) {
        // 创建属性集对象
        Properties properties = new Properties();
        // 添加键值对
        properties.setProperty("filename", "x.txt");
        properties.setProperty("length", "2098345");
        properties.setProperty("location", "E:/test");

        System.out.println(properties);

        // 通过键 获取值
        System.out.println(properties.getProperty("filename"));
        System.out.println(properties.getProperty("length"));
        System.out.println(properties.getProperty("location"));

        // 获取键的集合
        Set<String> strings = properties.stringPropertyNames();

        for (String key : strings) {
            System.out.println(key + "----" + properties.getProperty(key));
        }
    }
}

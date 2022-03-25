package cn.agree.test;

import redis.clients.jedis.Jedis;

public class JedisDemo01 {
    public static void main(String[] args) {

        // Jedis存储字符串类型的数据
        test01();

    }


    public static void test01() {
        // 1、设置ip地址和端口
        Jedis jedis = new Jedis("localhost", 6379);
        // 2、设置数据
        jedis.set("name", "agree");
        // 3、获取数据
        String name = jedis.get("name");
        System.out.println(name);
        // 释放资源
        jedis.close();
    }


}

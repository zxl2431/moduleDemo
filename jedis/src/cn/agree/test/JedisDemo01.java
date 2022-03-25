package cn.agree.test;

import cn.agree.utils.JedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisDemo01 {
    public static void main(String[] args) {

        // Jedis存储字符串类型的数据
        // test01();
        // 测试jedisPool
        // testJedisPool();

        // 测试jedisUtil
        testJedisUtil();

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

    public static void testJedisPool() {
        // 1、获取连接池配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(30);
        // 最大空闲连接数
        config.setMaxIdle(10);

        // 2 获得连接池
        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);

        // 3获取核心对象
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            // 4 设置数据
            jedis.set("name", "sdjfksd");
            // 5 获取数据
            String name = jedis.get("name");
            System.out.println(name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }

            // 虚拟机关闭时 释放pool
            if (jedisPool != null) {
                jedisPool.close();
            }
        }

    }


    public static void testJedisUtil() {
        Jedis jedis = JedisUtils.getJedis();
        // 设置数据
        jedis.set("name", "fdsfwwefs");
        // 获取数据
        String name = jedis.get("name");
        System.out.println(name);
        // 删除数据
        jedis.del("name");
        name = jedis.get("name");
        System.out.println(name);
    }

}

package cn.agree.demo;

import cn.agree.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JacksonDemo01 {
    public static void main(String[] args) throws JsonProcessingException {
        // 创建User对象
        User user = new User("张三", 16, "武汉");
        // 创建List集合
        List<String> arr = new ArrayList<>();
        arr.add("苹果");
        arr.add("香蕉");
        arr.add("梨子");
        // 创建map集合
        Map<String, User> map = new HashMap<>();
        map.put("user", user);

        // 转换
        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(user);
        String arrJson = objectMapper.writeValueAsString(arr);
        String mapJson = objectMapper.writeValueAsString(map);

        System.out.println(userJson);
        System.out.println(arrJson);
        System.out.println(mapJson);
    }
}

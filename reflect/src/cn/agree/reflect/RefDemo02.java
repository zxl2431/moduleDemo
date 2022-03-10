package cn.agree.reflect;

public class RefDemo02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class c = Class.forName("java.lang.String");
        // 获取简单类名
        String simpleName = c.getSimpleName();
        System.out.println("name="+simpleName);

        // 获取完整类名
        String name = c.getName();
        System.out.println("完整类名="+name);

        // 创建对象
        String str = (String) c.newInstance();
        System.out.println(str);


    }
}

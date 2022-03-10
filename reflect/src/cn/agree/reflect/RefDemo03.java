package cn.agree.reflect;

import cn.agree.pojo.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RefDemo03 {
    public static void main(String[] args) throws Exception {
        // test01();
        // test02();
        // test03();
        test04();
    }


    public static void test04() {
        System.out.println("----------- test04() -----------");
        // 获取Student类的Class对象
        Class c = Student.class;
        // 获取所有的构造方法
        Constructor[] cons = c.getDeclaredConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }
    }


    /**
     3. Constructor[] getConstructors()
     获取所有的public修饰的构造方法
     */
    public static void test03() {
        System.out.println("----------- test03() -----------");
        Class c = Student.class;
        // 获取public修饰的构造方法
        Constructor[] cons = c.getConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }
    }

    /**
     2. Constructor getDeclaredConstructor(Class... parameterTypes)
     根据参数类型获取构造方法对象，包括private修饰的构造方法。
     如果不存在对应的构造方法，则会抛出 java.lang.NoSuchMethodException 异常。
     */
    public static void test02() throws Exception {
        System.out.println("----------- test02() -----------");
        // 获取Student类的Class对象
        Class c = Student.class;
        // 获取对应的private修饰的构造方法对象
        Constructor cons =  c.getDeclaredConstructor(String.class, String.class);
        // private修饰的构造方法不能直接调佣instance创建对象 需要暴力反射
        cons.setAccessible(true);
        Student stu = (Student) cons.newInstance("刘德华", "女");
        System.out.println(stu);

    }

    /*
    *  getConstructor(class...parameterTypes)
    *  根据参数类型获取构造方法对象, 只能获得public修饰的构造方法
    *  如果不存在,会抛出java.lang.NoSuchMethodException
    * */
    public static void test01() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("-----------test01()--------------");
        Class c = Student.class;
        Constructor cons = c.getConstructor(String.class, String.class, int.class);
        Student stu = (Student) cons.newInstance("张曼玉", "女", 16);
        System.out.println(stu);
    }
}

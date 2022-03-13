package cn.agree.xmlparse;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class ParseXmlDemo {
    private SAXReader reader;
    private Document document;
    private Element rootElement;

    @Before
    public void before() throws DocumentException {
        //
        reader = new SAXReader();
        // System.out.println("先执行");
        document = reader.read("books2.xml");
        // 获取根标签
        rootElement = document.getRootElement();
        // System.out.println(rootElement);


    }

    @Test
    public void test01() {
        // System.out.println("执行test");
        // DOM4J的使用步骤
        String name = rootElement.getName();
        System.out.println(name);

        // 使用迭代器
        // 这个迭代器中存放的就是跟标签的所有子标签
        Iterator iterator = rootElement.elementIterator();
        while (iterator.hasNext()) {
            Element element = (Element) iterator.next();
            String name1 = element.getName();

            // 获取子标签的迭代器
            Iterator iterator1 = element.elementIterator();
            while (iterator1.hasNext()) {
                Element element1 = (Element) iterator1.next();
                System.out.println(name+":"+element1.getName()+"---"+element1.getText());
            }
        }
    }


    @Test
    public void test02() {
        // 使用elements()方法获取所有的子标签
        //
        List<Element> elements = rootElement.elements("书");
        for (Element element : elements) {
            System.out.println(element.getName()+"---"+element.getText());
        }
    }

    // @Test
    // public void test03() {
    //     //获取第一本书的出版社属性
    //     //1.先获取第一个"书"标签
    //     Element element = rootElement.element("书");
    //     //2.获取这个标签的属性
    //     Attribute attribute = element.attribute("价格");
    //     //3.通过属性对象获取属性值
    //     String value = attribute.getValue();
    //     System.out.println(value);
    // }
}

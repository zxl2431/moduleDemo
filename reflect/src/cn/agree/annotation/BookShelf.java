package cn.agree.annotation;

public class BookShelf {

    /*
    *  在类的成员方法上使用Book注解
    *
    * */
    @Book(value = "西游记", price = 998, authors = {"张三", "李四"})
    public void showBook() {

    }
}

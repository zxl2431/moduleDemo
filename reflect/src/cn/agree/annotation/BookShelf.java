package cn.agree.annotation;

@Book(value = "一千零一页", price = 1001, authors = {"安徒童话"})
public class BookShelf {

    /*
    *  在类的成员方法上使用Book注解
    *
    * */
    @Book(value = "西游记", price = 998, authors = {"张三", "李四"})
    public void showBook() {

    }
}

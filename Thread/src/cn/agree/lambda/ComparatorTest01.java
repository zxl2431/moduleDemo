package cn.agree.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest01 {
    public static void main(String[] args) {
        Person[] array = {
                new Person("古力娜扎", 19),
                new Person("迪丽热巴", 18),
                new Person("马尔扎哈", 20)
        };

        Comparator<Person> comparator = new Comparator<>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        };

        Arrays.sort(array, comparator);

        for (Person person : array) {
            System.out.println(person);
        }
    }
}

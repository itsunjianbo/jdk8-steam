package demo;

import bean.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxDemo {

    public static void main(String[] args) {


        //    List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        //    // 长度最大的字符串
        //    Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        //    System.out.println("最长的字符串：" + max.get());


        //    List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);
        //
        //    // 自然排序
        //    Optional<Integer> max = list.stream().max(Integer::compareTo);
        //    // 自定义排序
        //    Optional<Integer> max2 = list.stream().max(new Comparator<Integer>() {
        //        @Override
        //        public int compare(Integer o1, Integer o2) {
        //            return o1.compareTo(o2);
        //        }
        //    });
        //    System.out.println("自然排序的最大值：" + max.get());
        //    System.out.println("自定义排序的最大值：" + max2.get());


        //// TODO 获取员工工资最高的人。
        //List<Person> personList = new ArrayList<Person>();
        //personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        //personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        //personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        //personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        //personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        //personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
        //
        //Optional<Person> max = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        //System.out.println("员工工资最大值：" + max.get().getSalary());


        //// TODO 查询集合的长度
        //List<Integer> list = Arrays.asList(7, 6, 4, 8, 2, 11, 9);
        //long count = list.stream().filter(x -> x > 6).count();
        //System.out.println("list中大于6的元素个数：" + count);
        //
        //List<Integer> list1 = list.stream().filter(x -> x > 6).collect(Collectors.toList());
        //long count1 = list1.size();
        //System.out.println("list中大于6的元素个数：" + count1);

    }

}

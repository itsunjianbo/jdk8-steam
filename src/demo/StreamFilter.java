package demo;

import bean.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));


        // 筛选员工中工资高于8000的人，并形成新的集合
        personList.parallelStream().filter(x -> x.getSalary() > 8000).map(Person::getName).collect(Collectors.toList()).forEach(System.out::println);
        // 工资高于8000的list
        List<Person> arr = personList.parallelStream().filter(x -> x.getSalary() > 8000).collect(Collectors.toList());


        //
        List<String> fiterList = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName)
                .collect(Collectors.toList());
        System.out.print("高于8000的员工姓名：" + fiterList);
    }


}

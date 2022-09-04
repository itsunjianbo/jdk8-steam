package demo;

import bean.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 映射(map/flatMap)
 * 映射，可以将一个流的元素按照一定的映射规则映射到另一个流中。分为map和flatMap：
 * map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
 * flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
 */
public class MapDemo {

    public static void main(String[] args) {

        // TODO 案例一：英文字符串数组的元素全部改为大写。整数数组每个元素+3。
        String[] strArr = {"abcd", "bcdd", "defde", "fTr"};
        List<String> strList = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());

        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> intListNew = intList.stream().map(x -> x + 3).collect(Collectors.toList());

        System.out.println("每个元素大写：" + strList);
        System.out.println("每个元素+3：" + intListNew);

        System.out.println("--------------------------------------------------------------------------------");

        // TODO 案例二：将员工的薪资全部增加1000。
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        // 不改变原来员工集合的方式
        List<Person> personListNew = personList.stream().map(person -> {
            Person personNew = new Person(person.getName(), 0, 0, null, null);
            personNew.setSalary(person.getSalary() + 10000);
            return personNew;
        }).collect(Collectors.toList());
        System.out.println("一次改动前：" + personList.get(0).getName() + "-->" + personList.get(0).getSalary());
        System.out.println("一次改动后：" + personListNew.get(0).getName() + "-->" + personListNew.get(0).getSalary());

        // 改变原来员工集合的方式
        //List<Person> personListNew2 = personList.stream().map(person -> {
        //    person.setSalary(person.getSalary() + 10000);
        //    return person;
        //}).collect(Collectors.toList());
        //System.out.println("二次改动前：" + personList.get(0).getName() + "-->" + personListNew.get(0).getSalary());
        //System.out.println("二次改动后：" + personListNew2.get(0).getName() + "-->" + personListNew.get(0).getSalary());

        System.out.println("--------------------------------------------------------------------------------");

        // TODO 将工资小于8500的加1000块
        //personList.stream().map(par -> {
        //    if (par.getSalary() < 8500) {
        //        par.setSalary(par.getSalary() + 1000);
        //    }
        //    return par;
        //}).forEach(par -> System.out.println(par.toString()));

        System.out.println("--------------------------------------------------------------------------------");

        // TODO 案例三：将两个字符数组合并成一个新的字符数组。
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> listNew = list.stream().flatMap(s -> {
            // 将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).collect(Collectors.toList());

        System.out.println("处理前的集合：" + list);
        System.out.println("处理后的集合：" + listNew);

        System.out.println("--------------------------------------------------------------------------------");

    }


}

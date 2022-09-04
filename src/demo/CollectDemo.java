package demo;

import bean.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 收集(collect)
 * collect，收集，可以说是内容最繁多、功能最丰富的部分了。
 * 从字面上去理解，就是把一个流收集起来，最终可以是收集成一个值也可以收集成一个新的集合。
 */
public class CollectDemo {

    public static void main(String[] args) {

        // 归集
        //toList();

        // count
        //count();

        //group();

        tiqu();

    }

    /**
     * TODO 3.6.1  归集(toList/toSet/toMap)
     */
    private static void toList() {
        // TODO 3.6.1  归集(toList/toSet/toMap)
        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        List<Integer> listNew = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println("toList:" + listNew);

        Set<Integer> set = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());
        System.out.println("toSet:" + set);

        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));

        Map<?, Person> map = personList.stream().filter(p -> p.getSalary() > 8000)
                .collect(Collectors.toMap(Person::getName, p -> p));
        System.out.println("toMap:" + map);

        // 孙波波写的 简化的好理解的
        personList.stream()
                .filter(p -> p.getSalary() > 8000)
                .collect(Collectors.toMap(p -> p.getName(), p -> p));

        System.out.println("---------------------------------------------------------------------------------------");
    }

    /**
     * TODO 3.6.2 统计(count/averaging)
     * 计数：count
     * 平均值：averagingInt、averagingLong、averagingDouble
     * 最值：maxBy、minBy
     * 求和：summingInt、summingLong、summingDouble
     * 统计以上所有：summarizingInt、summarizingLong、summarizingDouble
     */
    public static void count() {

        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));

        // 求总数
        Long count = personList.stream().collect(Collectors.counting());
        // 求平均工资
        Double average = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
        // 求最高工资
        Optional<Integer> max = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compare));
        // 求工资之和
        Integer sum = personList.stream().collect(Collectors.summingInt(Person::getSalary));
        // 一次性统计所有信息
        DoubleSummaryStatistics collect = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));

        System.out.println("员工总数：" + count);
        System.out.println("员工平均工资：" + average);
        System.out.println("员工工资总和：" + sum);
        System.out.println("员工工资所有统计：" + collect);
    }

    /**
     * 分组(partitioningBy/groupingBy)
     * 分区 partitioningBy ：将stream按条件分为两个Map，比如员工按薪资是否高于8000分为两部分。
     * 分组 groupingBy ：将集合分为多个Map，比如员工按性别分组。有单级分组和多级分组。
     */
    public static void group() {
        // TODO 案例：将员工按薪资是否高于8000分为两部分；将员工按性别和地区分组

        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 1, "male", "New York"));
        personList.add(new Person("Jack", 7000, 2, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 3, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 4, "female", "New York"));
        personList.add(new Person("Owen", 9500, 5, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 6, "female", "New York"));

        // 将员工按薪资是否高于8000分组
        Map<Boolean, List<Person>> part = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        // 将员工按性别分组
        Map<String, List<Person>> group = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        // 将员工先按性别分组，再按地区分组
        Map<String, Map<String, List<Person>>> group2 = personList.stream()
                .collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        System.out.println("员工按薪资是否大于8000分组情况：" + part);
        System.out.println("员工按性别分组情况：" + group);
        System.out.println("员工按性别、地区：" + group2);

    }

    /**
     * 提取/组合
     * 流也可以进行合并、去重、限制、跳过等操作。
     * concat :合并
     * distinct : 去重
     * limit : 限制从流中获得前n个数据
     * skip : 跳过前n个数据
     */
    public static void tiqu() {

        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"d", "e", "f", "g"};

        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
        // concat:合并两个流 distinct：去重
        List<String> newList = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        // limit：限制从流中获得前n个数据
        List<Integer> collect = Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());
        // skip：跳过前n个数据
        List<Integer> collect2 = Stream.iterate(1, x -> x + 2).skip(1).limit(5).collect(Collectors.toList());

        System.out.println("流合并：" + newList);
        System.out.println("limit：" + collect);
        System.out.println("skip：" + collect2);

    }


}

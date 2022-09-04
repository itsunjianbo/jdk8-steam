package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 遍历/匹配（foreach/find/match）
 * Stream也是支持类似集合的遍历和匹配元素的，
 * 只是Stream中的元素是以Optional类型存在的。Stream的遍历、匹配非常简单。
 */
public class FindTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 7, 6, 9, 3, 8, 2, 1, 66, 77, 5, 555, 432, 30001);
        // 遍历输出符合条件的元素

        // TODO filter 筛选
        // TODO forEach 循环
        list.stream().filter(x -> x > 100).forEach(System.out::println);

        // 匹配第一个
        // TODO findFirst 查询第一个  findAny 查询任意一个
        Optional<Integer> first = list.stream().filter(x -> x > 300).findFirst();
        System.out.println(first.get());
        System.out.println(first.isPresent());
        // 匹配任意（适用于并行流）
        Optional<Integer> all = list.parallelStream().filter(x -> x < 100).findAny();
        System.out.println(all.orElse(9));

        // TODO anyMatch任何1个  ， allMatch 所有的 ， noneMatch 没有
        // 是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x > 6);
        boolean anyMatch1 = list.stream().allMatch(x -> x > 3000);
        boolean anyMatch2 = list.stream().noneMatch(x -> x > 3000);
        System.out.println("是否存在大于6的值：" + anyMatch);
        System.out.println("是否都大于3000的值：" + anyMatch1);
        System.out.println("是否没有大于3000的值：" + anyMatch2);


        //// 遍历输出符合条件的元素
        //list.stream().filter(x -> x > 6).forEach(System.out::println);
        //
        //
        //// 匹配第一个
        //Optional<Integer> findFirst = list.stream().filter(x -> x > 6).findFirst();
        //// 匹配任意（适用于并行流）
        //Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();
        //// 是否包含符合特定条件的元素
        //boolean anyMatch = list.stream().anyMatch(x -> x > 6);
        //System.out.println("匹配第一个值：" + findFirst.get());
        //System.out.println("匹配任意一个值：" + findAny.get());
        //System.out.println("是否存在大于6的值：" + anyMatch);
    }

}

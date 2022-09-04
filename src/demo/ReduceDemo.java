package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 归约(reduce)
 * 归约，也称缩减，顾名思义，是把一个流缩减成一个值，能实现对集合求和、求乘积和求最值操作。
 */
public class ReduceDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        // Sun
        // 求和方式1,小于10的求个和
        Optional<Integer> sum1 = list.stream().filter(x -> x<10).reduce(Integer::sum);
        System.out.println(sum1.orElse(0));

        // 求乘积,小于10的求个和
        Optional<Integer> product1 = list.stream().filter(x -> x<10).reduce((x,y) ->x*y);
        System.out.println(product1.orElse(0));


        // 求最大值写法2
        Optional<Integer> max1 = list.stream().filter(x -> x<10).reduce(Integer::max);
        System.out.println(max1.orElse(0));
















        // 求和方式1
        Optional<Integer> sum = list.stream().reduce((x, y) -> x + y);
        // 求和方式2
        Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
        // 求和方式3
        Integer sum3 = list.stream().reduce(0, Integer::sum);

        // 求乘积
        Optional<Integer> product = list.stream().reduce((x, y) -> x * y);

        // 求最大值方式1
        Optional<Integer> max = list.stream().reduce((x, y) -> x > y ? x : y);
        // 求最大值写法2
        Integer max2 = list.stream().reduce(1, Integer::max);

        System.out.println("list求和：" + sum.get() + "," + sum2.get() + "," + sum3);
        System.out.println("list求积：" + product.get());
        System.out.println("list求和：" + max.get() + "," + max2);
    }


}

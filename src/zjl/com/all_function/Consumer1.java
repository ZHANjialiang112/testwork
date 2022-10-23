package zjl.com.all_function;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 测试函数Consumer<T>，T代表传入的参数，没有任何的返回值，直接进行处理。
 */
public class Consumer1 {
    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s.length());
        consumer.accept("hello");
        List<String> list = Arrays.asList("hello", "key", "there", "have", "something");
        Map<Integer, String> collect = list.stream().collect(Collectors.toMap(v -> v.length(), v -> v,(v1,v2)->v2));
        System.out.println(collect);

        Consumer<Map<Integer,String>> convert = map -> {
            map.forEach((k,v) -> System.out.println(k + "=--=" + v));
        };
        convert.accept(collect);

        Consumer<String> listConsumer = s -> {
            System.out.println(s.toUpperCase());};

        list.forEach(listConsumer);
    }
}

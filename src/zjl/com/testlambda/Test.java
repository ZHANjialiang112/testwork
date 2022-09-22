package zjl.com.testlambda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        Runnable runnable = () -> {
//            System.out.println("hello world");
//        };
//        new Thread(runnable).start();
//        streamTest();
//        mapMathTest();
        BigDecimal bigDecimal = new BigDecimal("44441");
        BigDecimal divide = bigDecimal.multiply(new BigDecimal("25")).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(divide);
//        mapMathTest0();
    }

    public static void streamTest() {
        List<String> skills = Arrays.asList("java", "golang", "c++", "c", "python", "java");
        // Jdk8 之前
        for (String skill : skills) {
            System.out.print(skill + ",");
        }
        System.out.println("Jdk8 之后-去重遍历");
        // Jdk8 之后-去重遍历
        skills.stream().distinct().forEach(skill -> System.out.print(skill + ","));
        System.out.println("之后-去重遍历");
        // Jdk8 之后-去重遍历
        skills.stream().distinct().forEach(System.out::print);
        System.out.println("之后-去重，过滤掉 ptyhon 再遍历");
        // Jdk8 之后-去重，过滤掉 ptyhon 再遍历
        skills.stream().distinct().filter(skill -> skill != "python").forEach(skill -> System.out.print(skill + ","));
        System.out.println("之后-去重，过滤掉 ptyhon 再遍历");
        // Jdk8 之后转字符串
        String skillString = String.join(",", skills);
        System.out.println(skillString);
    }

    public static void mapMathTest0() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        IntSummaryStatistics stats = list.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("最小值：" + stats.getMin());
        System.out.println("最大值：" + stats.getMax());
        System.out.println("个数：" + stats.getCount());
        System.out.println("和：" + stats.getSum());
        System.out.println("平均数：" + stats.getAverage());
        // 求和的另一种方式
        Integer integer = list.stream().reduce(Integer::sum).get();
        System.out.println(integer);
    }

}

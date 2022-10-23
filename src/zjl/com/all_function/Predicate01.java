package zjl.com.all_function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author zjl
 *
 * 测试函数Predicate<T>，T表示传入的参数，返回的类型为一个Boolean类型值。
 * 可以多个Prediccte同时使用，and(且)，or（或），negate（取反）
 */
public class Predicate01 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> thanNum = num -> num > 5;
        Predicate<Integer> lessNum = num -> num < 9;
        func01(thanNum,lessNum,list);
    }
    public static void func01(Predicate<Integer> thanNum,Predicate<Integer> lessNum,List<Integer> list){
        list.forEach(m -> {
            if (thanNum.and(lessNum).test(m)) {
                System.out.print(m);
            }
        });
        System.out.println();
        list.forEach(m->{
            if (thanNum.and(lessNum).negate().test(m)) {
                System.out.print(m);
            }
        });
        System.out.println();
        list.forEach(m -> {
            if (thanNum.or(lessNum).test(m)) {
                System.out.print(m);
            }
        });
        System.out.println();
        list.forEach(m->{
            if (thanNum.or(lessNum).negate().test(m)) {
                System.out.print(m);
            }
        });
    }
}

package zjl.com.all_function;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author zjl
 *
 * 测试BiFunction<T,U,R>,T和U表示传入的参数，R表示返回的参数
 *
 * 可以使用andThen结合Function函数使用，会将BiFunction的R类型结果返回给Function
 */
public class BiFunction01 {
    public static void main(String[] args) {
        List<String> list1= Arrays.asList("ha", "txt", "text", "hello");
        List<String> list2= Arrays.asList("ha", "txt", "text", "hello");
        for (int i = 0; i < list1.size(); i++) {
            Integer integer = func01(list1.get(i), list2.get(i),
                    (m, r) -> m.length() + r.length(), m -> (int)Math.pow(m,2));
            System.out.println(integer);
        }
    }

    public static <T,U,R> R func01(T t, U u, BiFunction<T,U,R> biFunction, Function<R,R> function){
       return biFunction.andThen(function).apply(t, u);
    }
}

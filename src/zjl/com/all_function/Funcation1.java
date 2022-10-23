package zjl.com.all_function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


/**
 * 测试函数接口Function<T,R>，其中T表示传入的参数类型，R表示函数的返回类型。
 */
public class Funcation1 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("by", "six", "test", "admin");
        func(String::toUpperCase,strings);
    }

    public static <T,R> void func(Function<T,R> function, List<T> list){
        list.forEach(t -> {
            R apply = function.apply(t);
            if (apply instanceof String) {
                System.out.println(apply);
            }
        });
    }
}

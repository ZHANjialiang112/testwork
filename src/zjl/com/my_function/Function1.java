package zjl.com.my_function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Function1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("ha", "awm", "test", "hello");
        func(m -> m.toUpperCase(),list);
    }

    public static <T,R> void func(Function<T,R> function, List<T> list) {
        list.forEach(t -> {
            System.out.println(function.apply(t));
        });
    }

    }


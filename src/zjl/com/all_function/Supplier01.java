package zjl.com.all_function;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;

/**
 * @author zjl
 *
 * 测试函数接口Supplier<T>的的使用，没有任何参数，T代表返回的参数。
 */
public class Supplier01 {
    public static void main(String[] args) {
       final List<Integer> list = Arrays.asList(3, 4, 5, 6, 7);
        IntSupplier intSupplier = ()-> 2;

        list.forEach(m->{
            System.out.println(m+func01(intSupplier));
        });
    }

    public static int func01(IntSupplier intSupplier){
           return intSupplier.getAsInt();
    }
}

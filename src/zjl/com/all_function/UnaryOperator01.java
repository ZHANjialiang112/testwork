package zjl.com.all_function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * @author zjl
 *
 * 测试UnaryOperator<T>函数，UnaryOperator是Function的子类，UnaryOperator的返回参数和传入的参数相同
 */
public class UnaryOperator01 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "node", "c++", "rust", "www.wdbyte.com");
        List<String> list1 = func01(list, String::toUpperCase, s -> s.substring(0, 3));
        System.out.println(list1);
    }

    public static <T> List<T> func01(List<T> list, UnaryOperator<T>... operator){
        ArrayList<T> arrayList = new ArrayList<>();
        for (T t : list) {
            for (UnaryOperator<T> tUnaryOperator : operator) {
                t = tUnaryOperator.apply(t);
            }
            arrayList.add(t);
        }
        return arrayList;
    }
}

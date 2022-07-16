package zjl.com.copyarray;

import java.util.*;

/**
 * @Auther: ZJL
 * @Date: 2022/5/10 10:11
 * @Description:
 */
public class testCopyArray {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6};

        int array1[] = new int[array.length * 2];

        System.arraycopy(array,0,array1,0,array.length);

        int newArray[] = Arrays.copyOf(array, array.length * 2);

        System.out.println(Arrays.toString(array1));

        System.out.println(Arrays.toString(newArray));
        ArrayList<Integer> integers = new ArrayList<>();
        HashSet<Object> objects = new HashSet<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        objects.add(5);

        Iterator<Object> iterator = objects.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
        }

        for (Object object : objects) {

        }
    }
}

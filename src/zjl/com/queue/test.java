package zjl.com.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: ZJL
 * @Date: 2022/6/6 17:22
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        queue.add(1);
        queue.offer(2);
        Object element = queue.element();
        System.out.println(element);
        Object peek = queue.peek();
        System.out.println(peek);
        System.out.println(queue.size());
        System.out.println(queue.stream().count());
    }
}

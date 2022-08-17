package zjl.com.threadpool;

import java.util.ArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TestThread {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolTest.getThreadPoolExecutor();

        for (int i = 0; i < 15; i++) {
            int n = i;
            Future<?> future = threadPoolExecutor.submit(() -> {
                try {
                    System.out.println("开始执行：--" + n);
                    Thread.sleep(5000);
                    System.out.println("执行结束：--" + n);
                    System.out.println("核心线程池--"+threadPoolExecutor.getCorePoolSize());
                    System.out.println("线程池当前的大小--"+threadPoolExecutor.getPoolSize());
                    System.out.println("当前按键的数量--"+threadPoolExecutor.getTaskCount());
                    System.out.println("当前队列--"+threadPoolExecutor.getQueue());
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            });
        }
        try {
            Thread.sleep(50000);
            System.out.println("最后核心线程池--"+threadPoolExecutor.getCorePoolSize());
            System.out.println("最后线程池当前的大小--"+threadPoolExecutor.getPoolSize());
            System.out.println("最后当前按键的数量--"+threadPoolExecutor.getTaskCount());
            System.out.println("最后当前队列--"+threadPoolExecutor.getQueue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

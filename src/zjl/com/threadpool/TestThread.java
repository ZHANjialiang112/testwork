package zjl.com.threadpool;

import java.util.concurrent.ThreadPoolExecutor;

public class TestThread {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolTest.getThreadPoolExecutor();

        for (int i = 0; i < 30; i++) {
            int n = i;
            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println("开始执行：--" + n);
                    Thread.sleep(1000);
                    System.out.println("执行结束：--" + n);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            });
        }

    }
}

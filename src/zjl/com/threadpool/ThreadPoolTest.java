package zjl.com.threadpool;

import java.util.concurrent.*;

public class ThreadPoolTest {
    private static ThreadPoolExecutor threadPoolExecutor = null;

    private ThreadPoolTest(){}

    public static ThreadPoolExecutor getThreadPoolExecutor(){
        if (threadPoolExecutor == null) {
            synchronized (ThreadPoolTest.class){
                if (threadPoolExecutor == null) {
                    threadPoolExecutor = new ThreadPoolExecutor(3, 4, 10, TimeUnit.SECONDS,
                            new LinkedBlockingDeque<>(5), new ThreadFactory() {
                        @Override
                        public Thread newThread(Runnable r) {
                            return new Thread(r);
                        }
                    }, new RejectedExecutionHandler() {
                        @Override
                        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                            System.out.println("线程被拒绝执行："+r.getClass().getName());
                        }
                    });
                }
            }
        }
        return threadPoolExecutor;
    }
}

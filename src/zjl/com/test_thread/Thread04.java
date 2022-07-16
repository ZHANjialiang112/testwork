package zjl.com.test_thread;

/**
 * @Auther: ZJL
 * @Date: 2022/4/26 17:56
 * @Description: 测试ThreadLocal和inheritableThreadLocal
 */
public class Thread04 {
    //private static ThreadLocal<String> thLocal = new ThreadLocal<>();
    private static InheritableThreadLocal<String> thLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        thLocal.set("hello main");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+":"+thLocal.get());
            }
        });
        t1.start();
        System.out.println(Thread.currentThread()+
                ":"+thLocal.get());
    }
}

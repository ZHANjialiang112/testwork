package zjl.com.test_thread;

/**
 * @Auther: ZJL
 * @Date: 2022/4/26 17:28
 * @Description: 测试判断当前线程是否被中断，其中interrupted()判断后是会清楚标志物的，
 * 而isInterrupted()只是判断当前线程是否被中断。
 */
public class Thread03 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println("t1 还在运行中");
                    Thread.sleep(2000000);
                }
                }catch (Exception e){
                    System.out.println("当前线程被中断");
                }
            }
        });

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程完成");
    }
}

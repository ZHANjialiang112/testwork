package zjl.com.test_thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: ZJL
 * @Date: 2022/4/26 16:57
 * @Description:
 */
public class Thread02 {
    private static final Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                    LOCK.lock();
                try {
                    System.out.println("t1加锁~");
                    Thread.sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    LOCK.unlock();
                    System.out.println("t1解锁~");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                LOCK.lock();
                try {
                    System.out.println("t2加锁");
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    LOCK.unlock();
                    System.out.println("t2解锁");
                }
            }
        });

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();//中断休眠时的自进程会抛出异常java.lang.InterruptedException: sleep interrupted
        t2.start();
    }
}

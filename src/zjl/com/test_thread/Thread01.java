package zjl.com.test_thread;

/**
 * @Auther: ZJL
 * @Date: 2022/4/26 15:58
 * @Description: 测试wait（）,挂起一个线程，notify(),notifyAll()唤醒对应锁资源。
 */
public class Thread01 {
    private static volatile Object obj = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println("t1");
                    try {
                    System.out.println("t1的wait()开始~");
                        obj.wait();
                        System.out.println("t1的wait()结束~");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println("t2");
                try {
                    System.out.println("t2的wait（）方法开始");
                    obj.wait();
                    System.out.println("t2的wait方法结束~");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
               synchronized (obj){
                   System.out.println("t3开始执行notify（）");
                   obj.notify();
                   System.out.println("t3开始执行notifyAll（）");
                   obj.notifyAll();
               }
            }
        });

        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

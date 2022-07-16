package zjl.com.test_thread;

import javax.security.auth.callback.Callback;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther: ZJL
 * @Date: 2022/5/26 21:14
 * @Description:
 */
public class Thread_CallBack {
    public static void main(String[] args) {
        //FutureTask futureTask = new FutureTask(new ThreadCallBack());
        FutureTask<String> futureTask = new FutureTask<>(new ThreadCallBack());
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class ThreadCallBack implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("test hello");
        return "hello";
    }
}


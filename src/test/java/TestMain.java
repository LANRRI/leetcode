import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ruidli on 2017/6/12.
 */
public class TestMain {
    public static void main(String args[]) throws Exception {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("uncaught exception");
            }
        });
        ExecutorService abc = Executors.newFixedThreadPool(6);
        abc.execute(()->{
            System.out.println("thread exec");
                throw new Exception();
        });
    }
}

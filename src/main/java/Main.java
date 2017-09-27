import java.util.Scanner;

/**
 * Created by ruidli on 2017/9/18.
 */
public class Main {
    public static void main(String args[]) {
        Thread t1 = new Thread(new ReadString());
        Thread t2 = new Thread(new ReadString());
        Thread t3 = new Thread(new ReadString());
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ReadString.count);

    }

}

class ReadString implements Runnable {

    static Integer count = 0;
    static Integer count1 = 0;

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            synchronized (count1){
                count1++;
                if (count1>200000){
                    break;
                }
            }
            if (s.contains("u51")) {
                synchronized (count) {
                    count++;
                }
            }
        }
    }
}

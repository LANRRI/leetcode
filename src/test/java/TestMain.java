package iqiyi;

import java.util.Scanner;

/**
 * Created by ruidli on 2017/9/10.
 */
public class TestMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int count1 =0;
        for (int i = 1; i <= n; i++) {
            double result = Math.sqrt(i);
            if (result-(int)result == 0.0f){
                count1++;
            }
        }
        int count2 = 0;
        for (int i = 1; i <= m; i++) {
            double result = Math.sqrt(i);
            if (result-(int)result == 0.0f){
                count2++;
            }
        }
        System.out.println(count1*count2);
    }
}

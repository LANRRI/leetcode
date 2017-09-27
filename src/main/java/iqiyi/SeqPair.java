package iqiyi;

import java.util.Scanner;

/**
 * Created by ruidli on 2017/9/10.
 */
public class SeqPair {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int count1 = 0;
        for (int i = 1; i <= n; i++) {
            double result = Math.sqrt(i);
            if (Math.abs(result - Math.round(result)) < Math.pow(0.1, 5)) {
                count1++;
            }
        }
        int count2 = 0;
        for (int i = 1; i <= m; i++) {
            double result = Math.sqrt(i);
            if (Math.abs(result - Math.round(result)) < Math.pow(0.1, 5)) {
                count2++;
            }
        }
        System.out.println(count1 * count2 + Math.min(m, n));
    }
}

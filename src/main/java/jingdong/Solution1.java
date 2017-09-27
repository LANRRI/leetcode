package jingdong;

import java.util.Scanner;

/**
 * Created by ruidli on 2017/9/8.
 */
public class Solution1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int m = 1; m <= n; m++) {
                    for (int k = 1; k <= n; k++) {
                        if (Math.pow(i,k) == Math.pow(j,m)){
                            num++;
                        }
                    }
                }
            }
        }
        System.out.println(num );
    }
}

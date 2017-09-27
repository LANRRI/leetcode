package iqiyi;

/**
 * Created by ruidli on 2017/9/10.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String x1 = in.next();
        int k1 = in.nextInt();
        String x2 = in.next();
        int k2 = in.nextInt();
        if (x1.length() * k1 < x2.length() * k2) {
            System.out.println("Less");
        } else if (x1.length() * k1 > x2.length() * k2) {
            System.out.println("Greater");
        } else {
            StringBuffer s1 = new StringBuffer("");
            StringBuffer s2 = new StringBuffer("");
            for (int i = 0; i < k1; i++) {
                s1.append(x1);
            }
            for (int i = 0; i < k2; i++) {
                s2.append(x2);
            }
            boolean flag = false;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) < s2.charAt(i)) {
                    System.out.println("Less");
                    flag =true;
                    break;
                }else if (s1.charAt(i) > s2.charAt(i)){
                    System.out.println("Greater");
                    flag =true;
                    break;
                }
            }
            if (!flag){
                System.out.println("Equal");
            }
        }
    }
}

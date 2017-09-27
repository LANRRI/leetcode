package jingdong;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by ruidli on 2017/9/8.
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str.length() < 2 || str.length() > 20) ;
        Queue<Character> queue = new LinkedList<>();
        char[] arrChar = new char[20];
        arrChar = str.toCharArray();
        for (char i : arrChar) {
            queue.add(i);
        }
        int count = 0, sum = 1, result = 0;
        while (!queue.isEmpty()) {
            if (queue.poll() == '(') {
                count += 1;
                sum *= count;
            } else {
                while (count != 0) {
                    queue.poll();
                    count--;
                }
                result += sum;
                sum = 1;
            }
        }
        System.out.println(result);
    }
}

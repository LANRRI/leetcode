package iqiyi;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by ruidli on 2017/9/10.
 */
public class Kuohao {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<Character>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                int current = 0;
                if (stack.isEmpty()) {
                    System.out.println(max);
                    return;
                } else if (stack.peek() == '(') {
                    current++;
                    stack.pop();
                }else {
                    System.out.println(max);
                    return;
                }
                if (current > max){
                    max = current;
                }
            }
        }
        System.out.println(max);
    }
}
package iqiyi;
import java.util.*;

/**
 * Created by ruidli on 2017/9/10.
 */


public class Testtest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Stack<Character> stack = new Stack<>();
        int length = 0;
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                length++;
                stack.push(str.charAt(i));
            } else if (!stack.isEmpty() && ')' == str.charAt(i)) {
                if (length > max) {
                    max = length;
                }
                length = 0;
                stack.pop();
            }
        }
        System.out.println(max);
    }
}
package iqiyi;

import java.util.Scanner;

/**
 * Created by ruidli on 2017/9/21.
 */
public class Main2 {
    static void AllReverse(char str[]) {
        int len = str.length;
        int i = 0, j = len - 1;
        while (i < j) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            i++;
            j--;
        }
    }

    static void PartReverse(char str[]) {
        int i = 0;
        int begin = 0;
        int end = 0;
        while (i<str.length) {
            if (str[i] != ' ') {
                begin = i;
                while (str[i] != ' ' && i<str.length) i++;
                i--;
                end = i;
            }
            while (begin < end) {
                char tmp = str[begin];
                str[begin] = str[end];
                str[end] = tmp;
                begin++;
                end--;
            }
            i++;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] arr = s.toCharArray();
        AllReverse(arr);
        PartReverse(arr);
        System.out.println(arr.toString());

    }
}

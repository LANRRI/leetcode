package kazhongxin;

import java.util.Scanner;

/**
 * Created by ruidli on 2017/9/21.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[25][25];
        int n = sc.nextInt();
        for (int i = 0 ; i< n;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int j = x ; j<y;j++){
                arr[x][j] = 1;
            }
        }
        int max = 0;
        for (int j = 0;j<arr.length;j++){
            int current = 0;
            for (int i = 0;i<arr.length;i++){
                current+=arr[j][i];
            }
            if (max < current){
                max = current;
            }
        }
        System.out.println(max);
    }
}
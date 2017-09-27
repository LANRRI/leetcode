package iqiyi;

import java.util.Scanner;

/**
 * Created by ruidli on 2017/9/21.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long target = sc.nextLong();
        int line = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();
        long arr[][] = new long[line][col];
        for (int i = 0 ; i< line;i++){
            for(int j = 0 ; j<col;j++){
                arr[i][j] = sc.nextLong();
            }
        }
        stepWise(arr,line,col,target);

    }


    static void stepWise(long mat[][], int maxRow,int maxCol, long target) {
        if (target < mat[0][0] || target > mat[maxRow-1][maxCol-1]) System.out.println("-1 -1");
        int row = 0;
        int col = maxCol-1;
        while (row <= maxRow-1 && col >= 0) {
            if (mat[row][col] < target)
                row++;
            else if (mat[row][col] > target)
                col--;
            else
                break;
        }
        if (row <= maxRow-1 && col >= 0){
            System.out.println(row + " "+ col);
        }else {
            System.out.println("-1 -1");
        }
    }
}

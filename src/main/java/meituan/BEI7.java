package meituan;

import java.util.Scanner;

/**
 * Created by ruidli on 2017/9/14.
 */
public class BEI7 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int count = 0;
        while (!judge(arr)){
            for (int i = 0 ; i <n ; i++){
                if (arr[i] == 0){
                    for (int j = i ;j<n;j++){
                        if (arr[i] == 0){
                            arr[i] = 1;
                        }else{
                            arr[i] = 0;
                        }
                    }
                    count++;
                }
                if (count>5000){
                    break;
                }
            }
        }
        if (count%2 == 1){
            System.out.println("Alice");
        }else{
            System.out.println("Bob");
        }

    }
    static boolean judge(int[] arr){
        int sum = 0;
        for (int i = 0 ; i<arr.length;i++){
            sum+= arr[i];
        }
       return sum!=arr.length? false:true;
    }
}

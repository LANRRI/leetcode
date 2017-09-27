package util.sort;

/**
 * Created by ruidli on 2017/9/27.
 */
public class Sort {
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) break;
        }
    }


    public static int quickSort(int arr[], int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            for (; low < high && arr[high] >= pivot; high--) ;
            arr[low] = arr[high];
            for (; low < high && arr[low] <= pivot; low++) ;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
    public static void quickMain(int arr[],int low ,int high){
        if (low >= high) return;
        int index = quickSort(arr,low,high);
        quickSort(arr,low,index-1);
        quickSort(arr,index+1,high);
    }


    public static void main(String args[]){
        int arr[] = {1,3,5,2,4,2};
        quickMain(arr,0,arr.length-1);
        System.out.println(arr);
    }

}

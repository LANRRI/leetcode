package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ruidli on 2017/9/7.
 */
public class FolderSize {
    public static void main(String args[]){
        String[] files = {"0 55", "0 47", "1 22", "1 21"};
        System.out.println(calculateWaste(files,3,50));

    }
   public static int[] calculateWaste(String[] files, int folderCount, int chunkSize){
        Map<String,List<Integer>> fileMap = new HashMap<>();
        for(int i = 0 ; i< files.length;i++){
            String key = files[i].split(" ")[0];
            int value = Integer.parseInt(files[i].split(" ")[1]);
            List<Integer> valueList = fileMap.get(key);
            if(valueList == null){
                valueList = new ArrayList<>();
            }
            valueList.add(value);
            fileMap.put(key,valueList);
        }

        int[] arr = new int[folderCount];
        for (int i = 0 ; i<folderCount;i++){
            List<Integer> valueList = fileMap.get(String.valueOf(i));
            if (valueList == null){
                break;
            }
            for (Integer value : valueList){
                arr[i] += chunkSize-value%chunkSize;
            }
        }
        return arr;
    }
}

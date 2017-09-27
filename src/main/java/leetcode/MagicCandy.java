package yuanjing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ruidli on 2017/9/7.
 */
public class MagicCandy {
    public static void  main(String args[]){
        System.out.println(whichOne(9));
    }
    public static int whichOne(int n){
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i< n;i++){
            list.add(i+1);
        }
        while (list.size() > 1){
            List<Integer> subList = new ArrayList<>();
            int size = list.size();
            for (int i = 1 ; i <= size && Math.pow(i,2)<= size; i++){
                subList.add(list.get((int)Math.pow(i,2)-1));
            }
            list.removeAll(subList);
        }
        return list.get(0);
    }
}

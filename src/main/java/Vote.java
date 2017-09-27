import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ruidli on 2017/9/18.
 */
public class Vote {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String vote[] = s.split(" ");
        String ss = sc.nextLine();
        String weight[] = ss.split(" ");
        HashMap<String, V> map = new HashMap<>();
        for (int i = 0; i < vote.length; i++) {
            V v = map.get(vote[i]);
            if (v == null) {
                map.put(vote[i], new V(Integer.parseInt(weight[i]), 1));
                continue;
            }
            v.num++;
            v.weight += Integer.parseInt(weight[i]);
        }
        String id = "";
        int num = 0;
        int value = 0;

        for (Map.Entry<String, V> entry : map.entrySet()) {
            if (entry.getValue().weight > value ||
                    (entry.getValue().weight == value
                            && num < entry.getValue().num)) {
                value = entry.getValue().weight;
                num = entry.getValue().num;
                id = entry.getKey();
                continue;
            }
        }
        System.out.println(id);
    }
}

class V {
    int weight;
    int num;

    public V(int weight, int num) {
        this.weight = weight;
        this.num = num;
    }
}

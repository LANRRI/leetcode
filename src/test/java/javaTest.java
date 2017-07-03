import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ruidli on 2017/6/14.
 */
public class javaTest {
    public static void main(String args []){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
       List list1 =  list.stream().filter(f->f>20).map(f->f.longValue()).collect(Collectors.toList());
        System.out.print(list.contains(2));

    }
}

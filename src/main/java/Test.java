/**
 * Created by ruidli on 2017/9/13.
 */
public class Test extends Thread {
    public static void main(String args[]) {
        Test test1 = new Test();
        Test test2 = new Test();
        test1.start();
        System.out.println("one");
        test2.start();
        System.out.println("two");
    }

    public void run() {
        System.out.println("Thread.");
    }
//输入：数据集、最小值尺度
//输出：FP树、头指针表
//1. 遍历数据集，统计各元素项出现次数，创建头指针表
//2. 移除头指针表中不满足最小值尺度的元素项
//3. 第二次遍历数据集，创建FP树。对每个数据集中的项集：
//    3.1 初始化空FP树
//    3.2 对每个项集进行过滤和重排序
//    3.3 使用这个项集更新FP树，从FP树的根节点开始：
//        3.3.1 如果当前项集的第一个元素项存在于FP树当前节点的子节点中，
//              则更新这个子节点的计数值
//        3.3.2 否则，创建新的子节点，更新头指针表
//        3.3.3 对当前项集的其余元素项和当前元素项的对应子节点递归3.3的过程
}

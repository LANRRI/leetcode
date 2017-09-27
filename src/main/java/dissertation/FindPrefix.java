//package dissertation;
//
///**
// * Created by ruidli on 2017/9/13.
// */
//public class FindPrefix {
//    def findPrefixPath(basePat, treeNode):
//            ''' 创建前缀路径 '''
//    condPats = {}
//    while treeNode != None:
//    prefixPath = []
//    ascendTree(treeNode, prefixPath)
//        if len(prefixPath) > 1:
//    condPats[frozenset(prefixPath[1:])] = treeNode.count
//            treeNode = treeNode.nodeLink
//    return condPats
//
////    输入：我们有当前数据集的FP树（inTree，headerTable）
////      1. 初始化一个空列表preFix表示前缀
////      2. 初始化一个空列表freqItemList接收生成的频繁项集（作为输出）
////      3. 对headerTable中的每个元素basePat（按计数值由小到大），递归：
////        3.1 记basePat + preFix为当前频繁项集newFreqSet
////        3.2 将newFreqSet添加到freqItemList中
////        3.3 计算t的条件FP树（myCondTree、myHead）
////        3.4 当条件FP树不为空时，继续下一步；否则退出递归
////        3.5 以myCondTree、myHead为新的输入，以newFreqSet为新的preFix，
////            外加freqItemList，递归这个过程
//}

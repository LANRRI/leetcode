package util.binaryTree;

import java.util.List;

/**
 * Created by ruidli on 2017/9/22.
 */
public class BinaryTreeOpration {
    public static int binaryTreeDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = binaryTreeDepth(root.left);
        int rightDepth = binaryTreeDepth(root.right);

        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }


    // abandon
    public static boolean balanceTree(TreeNode root) {
        if (root == null) return true;

        int leftDepth = binaryTreeDepth(root.left);
        int rightDepth = binaryTreeDepth(root.right);

        if (Math.abs(leftDepth - rightDepth) > 2) return false;
        return balanceTree(root.left) && balanceTree(root.right);
    }


    public static boolean isBalance(TreeNode root, Integer depth) {
        if (root == null) {
            depth = 0;
            return true;
        }
        Integer leftDepth = 0, rightDepth = 0;
        boolean bleft = isBalance(root.left, leftDepth);
        boolean bright = isBalance(root.right, rightDepth);
        if (bleft && bright) {
            if (Math.abs(leftDepth - rightDepth) < 2) {
                depth = leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
                return true;
            }
        }
        return false;
    }

    public static boolean isBalance(TreeNode root) {
        Integer depth = 0;
        return isBalance(root, depth);
    }

    public static TreeNode findParent(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) return null;
        if (root == A || root == B) return root;
        TreeNode left = findParent(root.left, A, B);
        TreeNode right = findParent(root.right, A, B);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }


    public static boolean getPath(TreeNode root, TreeNode target, List<Integer> path) {
        if (root == target) {
            return true;
        }
        if (root == null) {
            return false;
        }
        path.add(root.value);
        boolean found = false;
        found = getPath(root.left, target, path);
        if (!found) {
            found = getPath(root.right, target, path);
        }
        if (!found) path.remove(path.size() - 1);
        return found;
    }
}

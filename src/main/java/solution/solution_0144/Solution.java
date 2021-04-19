package solution.solution_0144;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * 
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * */
public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

        System.out.println(prologueTraversalWithFor(treeNode));
    }

    /**
     * 前序遍历. 套用模板后先放入父节点的值, 再将对其左右子节点递归操作
     * 前序遍历, 上左右
     * */
    private static List<Integer> prologueTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        prologueTraversal(root, res);
        return res;
    }
    private static void prologueTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        prologueTraversal(root.left, res);
        prologueTraversal(root.right, res);
    }

    /**
     * 迭代
     * 子循环一直去左节点, 并放入栈内, 直至左节点为null
     * 此时弹出一个栈顶, 将右节点放入栈内
     * 取出刚放进来的右节点, 继续子循环,取左节点
     * */
    private static List<Integer> prologueTraversalWithFor(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }
}

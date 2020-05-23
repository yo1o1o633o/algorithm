package solution_0606;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Tree2str {
    /**
     * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
     *
     * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
     * */
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.right = new TreeNode(3);
        System.out.println(tree2str(treeNode));
        System.out.println(tree2str2(treeNode));
    }

    /**
     * 递归
     * */
    private static String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return t.val + "";
        }
        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }

    /**
     * 迭代
     * 前序遍历
     * 先走左侧， 当左侧为null时走右侧。
     * 采用栈来存储左侧序列
     * 采用集合来判断右括号
     * 1. 先将根节点放入栈中
     * 2. 去除这个节点
     * 3. 将值拼接后判断左右是否位null
     * 4. 不为null就入栈， 右侧先入， 因为要左侧先出
     * 5. 继续取出栈顶结点
     * 6. 循环上边的操作， 如果碰到左侧节点为null又不为null。那么拼接（）
     * */
    private static String tree2str2(TreeNode t) {
        if (t == null) {
            return "";
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        stack.add(t);
        StringBuilder res = new StringBuilder();
        while (!stack.empty()) {
            TreeNode s = stack.peek();
            if (set.contains(s)) {
                stack.pop();
                res.append(")");
            } else {
                set.add(s);
                res.append("(").append(s.val);
                if (s.left == null && s.right != null) {
                    res.append("()");
                }
                if (s.right != null) {
                    stack.push(s.right);
                }
                if (s.left != null) {
                    stack.push(s.left);
                }
            }
        }
        return res.toString().substring(1, res.length() - 1);
    }
}

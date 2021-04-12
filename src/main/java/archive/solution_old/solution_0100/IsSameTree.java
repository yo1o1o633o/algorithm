package archive.solution_old.solution_0100;

import java.util.ArrayDeque;

/**
 * @author Yang
 */
public class IsSameTree {
    /**
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     *
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    /**
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     *
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * */
    public static void main(String[] args) {
        // 定义两个二叉树
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(3);

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(2);
        treeNode2.right = new TreeNode(3);

//        System.out.println(isSameTree(treeNode1, treeNode2));
        System.out.println(isSameTree2(treeNode1, treeNode2));
    }

    /**
     * 递归. 递归对左右分叉进行分别对比
     * */
    private static boolean isSameTree(TreeNode p, TreeNode q) {
        // 两个都null
        if (p == null && q == null) {
            return true;
        }
        // 只有一个是null
        if (q == null || p == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 使用队列 ArrayDeque 是一种JAVA数据类型. 保存队列
     * ArrayDeque特点
     * 非线程安全的. 在没有外部同步情况下无法在多线程情况下使用
     * 作为栈使用性能高于Stack类
     * 不支持null值
     * 底层是一个可变数组, 没有容量限制.
     *
     * 此处进行循环判断, 当当前节点相等时, 将左右两边子节点放入队列中, 用于下次循环取出进行对比
     * */
    private static boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (check(p, q)) {
            return false;
        }
        ArrayDeque<TreeNode> dequeP = new ArrayDeque<>();
        ArrayDeque<TreeNode> dequeQ = new ArrayDeque<>();
        dequeP.add(p);
        dequeQ.add(q);

        while (!dequeP.isEmpty()) {
            p = dequeP.removeFirst();
            q = dequeQ.removeFirst();
            if (check(p, q)) {
                return false;
            }
            if (check(p.left, q.left)) {
                return false;
            }
            if (p.left != null) {
                dequeP.addLast(p.left);
                dequeQ.addLast(q.left);
            }
            if (check(p.right, q.right)) {
                return false;
            }
            if (p.right != null) {
                dequeP.addLast(p.right);
                dequeQ.addLast(q.right);
            }
        }
        return true;
    }

    private static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return false;
        }
        if (p == null || q == null) {
            return true;
        }
        if (p.val != q.val) {
            return true;
        }
        return false;
    }
}

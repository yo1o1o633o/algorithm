package archive.solution_old.solution_0103;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shuai.yang
 */
public class ZigzagLevelOrder {
    /**
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(zigzagLevelOrder(treeNode));
    }

    /**
     * 广搜
     * 定义一个标记.index 单数从前从后记录. 双数从后向前记录
     * */
    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        int index = 1;
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = linkedList.pop();
                if (pop != null) {
                    if (index % 2 == 1) {
                        list.add(pop.val);
                    } else {
                        list.add(0, pop.val);
                    }
                    if (pop.left != null) {
                        linkedList.add(pop.left);
                    }
                    if (pop.right != null) {
                        linkedList.add(pop.right);
                    }
                }
            }
            result.add(list);
            index++;
        }
        return result;
    }
}

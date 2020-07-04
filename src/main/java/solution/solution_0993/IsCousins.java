package solution.solution_0993;

import entity.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author shuai.yang
 */
public class IsCousins {
    /**
     * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
     *
     * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
     *
     * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
     *
     * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
     * 两个结点在同一层, 但是不是一个父节点的
     * */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        int x = 4;
        int y = 3;
        System.out.println(isCousins(treeNode1, x, y));
    }

    /**
     * 广度搜索.
     * 在同一层找值为x和y的节点. 如果在同一层. 再判断两个节点是否在同一个父节点下.
     * */
    private static boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    set.add(poll.val);
                    if (poll.left != null && poll.right != null) {
                        if (poll.left.val == x && poll.right.val == y) {
                            return false;
                        } else if (poll.right.val == x && poll.left.val == y) {
                            return false;
                        }
                    }
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                }
            }
            if (set.contains(x) && set.contains(y)) {
                return true;
            }
        }
        return false;
    }
}

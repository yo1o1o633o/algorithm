package probe.queue;

import entity.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author shuai.yang
 */
public class BfsTemplate {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(2);
        System.out.println(bfs(treeNode, new TreeNode(3)));
    }

    private static int bfs(TreeNode treeNode, TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);

        int step = 0;
        while (!queue.isEmpty()) {
            step = step + 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.peek();
                if (head != null) {
                    if (head.val == target.val) {
                        return step;
                    }
                    queue.add(head.left);
                    queue.add(head.right);
                }
                queue.poll();
            }
        }
        return -1;
    }

    /**
     * 确保不重复
     * 使用哈希表
     * */
    private static int bfsNoRepeat(TreeNode treeNode, TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        int step = 0;
        queue.add(treeNode);
        set.add(treeNode);
        while (!queue.isEmpty()) {
            step = step + 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.peek();
                if (head != null) {
                    if (head.val == target.val) {
                        return step;
                    }
                    if (set.contains(head.left)) {
                        queue.add(head.left);
                        set.add(head.left);
                    }
                    if (set.contains(head.right)) {
                        queue.add(head.right);
                        set.add(head.right);
                    }
                }
            }
        }
        return -1;
    }
}

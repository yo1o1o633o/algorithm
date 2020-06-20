package probe.stack;

import entity.TreeNode;

import java.util.Set;

/**
 * @author shuai.yang
 */
public class DfsTemplate {
    public static void main(String[] args) {

    }

    private static boolean dfs(TreeNode node, Integer target, Set<TreeNode> visited) {
        if (node.val == target) {
            return true;
        }
        if (!visited.contains(node.left)) {
            visited.add(node.left);
            return dfs(node.left, target, visited);
        }
        if (!visited.contains(node.right)) {
            visited.add(node.right);
            return dfs(node.right, target, visited);
        }
        return false;
    }
}

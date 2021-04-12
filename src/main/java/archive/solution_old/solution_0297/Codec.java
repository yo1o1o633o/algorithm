package archive.solution_old.solution_0297;

import entity.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shuai.yang
 */
class Codec {

    String serialize(TreeNode root) {
        return serialize(root, "");
    }
    /**
     * 前序遍历
     * */
    private String serialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += root.val + ",";
            str = serialize(root.left, str);
            str = serialize(root.right, str);
        }
        return str;
    }

    TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(strings));
        return deserialize(list);
    }

    private TreeNode deserialize(List<String> list) {
        if ("None".equals(list.get(0))) {
            list.remove(0);
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        treeNode.left = deserialize(list);
        treeNode.right = deserialize(list);

        return treeNode;
    }
}

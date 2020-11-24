package solution_old.solution_0108;

public class SortedArrayToBST {
    /**
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(nums));
    }

    /**
     * 二分法思路
     *
     * 为了维持左右高度一致，那么左右节点的数量应该也是一致的， 递归二分。 平均分发的子节点去
     *
     * */
    private static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);

        treeNode.left = helper(nums, left, mid - 1);
        treeNode.right = helper(nums, mid + 1, right);
        return treeNode;
    }
}

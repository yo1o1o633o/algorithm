package easy;

/**
 * @author Yang
 */
public class RemoveElement {
    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * */
    public static void main(String[] args) {
        int[] num = new int[]{3,2,2,3};
        RemoveElement removeElement = new RemoveElement();
        removeElement.removeElement(num, 3);
    }

    /**
     * 此解法本地执行有问题, 力扣正常
     * 本地输出2223
     * */
    private int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        System.out.println(nums.length);
        return j;
    }
}

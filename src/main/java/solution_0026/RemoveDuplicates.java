package solution_0026;

/**
 * @author Yang
 */
public class RemoveDuplicates {
    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * */
    public static void main(String[] args) {
        int[] num = new int[]{1,1,2,3,4};
        System.out.println(removeDuplicates(num));
    }

    /**
     * 双指针方式
     * i为慢指针, 初始0
     * j为快指针, 从1开始
     * 两两判断, 前后不相等. 保存两个值. 否则跳过
     * j++要先赋值, 因为不相等表示元素个数加一个, 保存到后一位
     * */
    private static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}

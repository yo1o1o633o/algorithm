package archive.solution;

/**
 * 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @author shuai.yang
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    /**
     * 双指针.
     * 快指针用来寻找下一个比慢指针大的值, 赋值给慢指针的下一个元素.
     * 每次替换计数值+1
     * 最后统计总的计数值. i是从0开始的, 移动的次数+1就是结果数组
     * */
    private static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            // 如果相同,快指针前进
            if (nums[i] == nums[j]) {
                j++;
                continue;
            }
            // 如果大于慢指针, 那么赋值到慢指针下一个元素
            if (nums[i] < nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }
}

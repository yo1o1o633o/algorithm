package solution_old.solution_0027;

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
        /**
         * 引用传递, 所以定义两个数组测试, 否则第一个方法会影响第二个方法的结果. 如果传入同一个数组的话
         * */
        int[] num = new int[]{3,2,2,3};
        int[] num2 = new int[]{3,2,2,3};
        int val = 3;
        System.out.println(removeElement(num, val));
        System.out.println(removeElement2(num2, val));
    }

    /**
     * 双指针
     * 对题解理解有问题. 只是将后一个元素向前复制. 数组的大小并没有变. 是复制不是移动. 最后截取满足条件个数的数组元素
     * */
    private static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    /**
     * 双指针, 循环判断, 如果相等就将最后一个元素复制到当前的元素位置.
     * 如果不相等, 那么向后移动继续判断
     * 每发现一个相等的元素, 长度就减一
     * */
    private static int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}

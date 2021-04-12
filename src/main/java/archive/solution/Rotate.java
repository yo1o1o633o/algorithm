package archive.solution;

import java.util.Arrays;

/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * */
public class Rotate {
    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        rotateWithRing(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 冒泡
     * 两两交换，模拟移动操作。两层循环后就是移动后的结果
     * */
    private static void rotateWithViolence(int[] nums, int k) {
        for (int j = 0; j < k; j++) {
            for (int i = nums.length - 1; i > 0; i--) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    }

    /**
     * 这个方法基于这个事实：当我们旋转数组 k 次， k%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
     * */
    private static void rotateWithFlip(int[] nums, int k) {
        // 防止数组越界
        k %= nums.length;
        // 整体翻转
        reverse(nums, 0, nums.length - 1);
        // 左边翻转
        reverse(nums, 0, k - 1);
        // 右边翻转
        reverse(nums, k, nums.length - 1);
    }
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 环形处理。直接依次将元素放入到应该移动到的位置上。
     * 特殊情况 当k和n的最大公约数不为1时 ， 会造成回到原点情况。如 1， 2， 3， 4 移动 2.  则3会移动1位置。2，4无法处理
     * 双重循环， 当出现上述情况时， 向前进1位继续操作。
     * 记录总的移动次数用于跳出循环
     * */
    private static void rotateWithRing(int[] nums, int k) {
        // 用于判断退出循环条件, 每次移动+1, 最多移动元素个数次
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            // 获取节点, 避免越界
            k = k % nums.length;
            int current = i;
            int n = nums[i];
            // 先执行移动, 当除了第一次移动外, 碰到回到原点情况, 表示特殊情况：当k和n的最大公约数不为1时
            do {
                // 获取下一个节点
                int next = (k + current) % nums.length;
                // 保存下个节点值, 为要插入的元素提供位置
                int temp = nums[next];
                // 在下一个节点插入元素
                nums[next] = n;
                // 将被挤出的元素保存到临时变量中
                n = temp;
                // 移动到下个节点继续操作
                current = next;
                // 记录移动次数
                count++;
            } while (current != i);
        }
    }
}

package offer.offer_011;

import java.util.Arrays;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * */
public class Solution {
    public static void main(String[] args) {
        int[] numbers = {3,4,5,1,2};
        System.out.println(minArrayWithDichotomous(numbers));
    }

    public static int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }

    public static int minArrayWithSort(int[] numbers) {
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            min = Math.min(min, number);
        }
        return min;
    }

    private static int minArrayWithDichotomous(int[] numbers) {
        return help(numbers, 0, numbers.length - 1);
    }
    private static int help(int[] numbers, int start, int end) {
        if (start == end) {
            return numbers[start];
        }
        int mid = (start + end) / 2;
        return Math.min(help(numbers, start, mid), help(numbers, mid + 1, end));
    }

    /**
     * 数组一定是一个递增数组通过旋转得到的，即两个递增的数组
     * 那么中间的值如果比末尾的大，那么旋转点一定是在后半部
     * 34567   12
     * 中间值为6和2比较，6>2则表示6在左排序中，那么向右找下一个点7， 7>2依然在左排序中， 继续找。 得到1， 1<2. 则1在右序列中。
     * 则右边界直接赋值该值。 跳出循环。
     * */
    private static int minArrayWithDichotomous2(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (numbers[mid] > numbers[j]) {
                i = mid + 1;
            } else if (numbers[mid] == numbers[j]) {
                j = j - 1;
            } else {
                j = mid;
            }
        }
        return numbers[i];
    }
}

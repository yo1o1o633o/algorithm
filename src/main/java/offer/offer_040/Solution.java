package offer.offer_040;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {3,2,1};
        System.out.println(Arrays.toString(getLeastNumbersWithSort(arr, 2)));
    }

    /**
     * 最小堆, 依次取出指定个数堆顶元素
     */
    private static int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for (int i : arr) {
            min.offer(i);
        }
        int[] res = new int[k];

        int i = 0;
        while (!min.isEmpty()) {
            if (i == k) {
                break;
            }
            res[i] = min.poll();
            i++;
        }
        return res;
    }

    /**
     * 数组排序, 直接拷贝前k个元素
     */
    private static int[] getLeastNumbersWithSort(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }
}

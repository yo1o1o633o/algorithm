package archive.solution;

import java.util.*;

/**
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * @author shuai.yang
 */
public class Intersect {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2, 2};
        int[] intersect = intersectWithDoublePoint(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
    }

    /**
     * 双指针.
     * 对两个数组进行排序
     * 不相等时较小的数组前进
     * 相等的时候就保存.同时前进
     * */
    private static int[] intersectWithDoublePoint(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int k = 0;
        // 性能提升点.交集个数一定小于等于较小的数组个数.
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                res[k] = nums1[i];
                k++;
                i++;
                j++;
            }
        }
        // copyOfRange数组拷贝时,原数组越大性能越差.
        return Arrays.copyOfRange(res, 0, k);
    }

    /**
     * 哈希表
     * 记录每个元素的次数
     * 遍历另一个数组, 当碰到存在的元素时, 计数-1, 同时保存到返回结果中
     * */
    private static int[] intersectWithHash(int[] nums1, int[] nums2) {
        // 加这行判断性能降低
        if (nums1.length > nums2.length) {
            return intersectWithHash(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            Integer count = map.getOrDefault(n, 0) + 1;
            map.put(n, count);
        }
        int i = 0;
        int[] res = new int[nums2.length];
        for (int n : nums2) {
            Integer count = map.getOrDefault(n, 0);
            if (count == 0) {
                continue;
            }
            res[i++] = n;
            count--;
            map.put(n, count);
        }
        return Arrays.copyOf(res, i);
    }
}

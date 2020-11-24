package solution_old.solution_0349;

import java.util.*;

/**
 * @author shuai.yang
 */
public class Intersection {
    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * */
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
        System.out.println(Arrays.toString(intersection1(nums1, nums2)));
    }

    /**
     * 两个hashSet来处理. 先把第一个数组放入set中. 然后判断第二个数组在集合中的就是交集. 并且set支持去重
     * */
    private static int[] intersection(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (Integer n : nums1) {
            set1.add(n);
        }
        for (Integer n : nums2) {
            set2.add(n);
        }
        int index = 0;
        for (Integer n : set1) {
            if (set2.contains(n)) {
                res[index] = n;
                index++;
            }
        }
        int[] r = new int[index];
        for (int i = 0; i < index; i++) {
            r[i] = res[i];
        }
        return r;
    }

    private static int[] intersection1(int[] nums1, int[] nums2) {
        int length = Math.max(nums1.length, nums2.length);
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (i < nums1.length) {
                set1.add(nums1[i]);
            }
            if (i < nums2.length) {
                set2.add(nums2[i]);
            }
        }
        int[] res = new int[nums1.length];
        int index = 0;
        for (Integer n : set1) {
            if (set2.contains(n)) {
                res[index] = n;
                index++;
            }
        }
        return Arrays.copyOf(res, index);
    }
}

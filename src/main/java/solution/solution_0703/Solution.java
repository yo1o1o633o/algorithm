package solution.solution_0703;

import java.util.*;

/**
 * 703. 数据流中的第 K 大元素
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 */
public class Solution {

    public static void main(String[] args) {
        int[] s = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, s);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

    /**
     * 使用最小堆
     * 维持堆内只有key个元素, 每加一个就判断下是否超过k个  超过就把堆顶移除了, 堆顶就永远是第k大的元素
     * */
    static class KthLargest {
        int k;
        PriorityQueue<Integer> min = new PriorityQueue<>();

        KthLargest(int k, int[] nums) {
            this.k = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            min.offer(val);
            if (min.size() > k) {
                min.poll();
            }
            Integer r = min.peek();
            return r == null ? 0 : r;
        }
    }

    /**
     * 使用列表, 和上边的逻辑一样, 每次都要排序, 超时了
     * PS: 题目要求输入的是数据流, 业务上处于online状态, 当输入量很大时排序会有丢失,业务上不能接受
     * */
    static class KthLargestWithList {
        int k;
        LinkedList<Integer> list = new LinkedList<>();

        KthLargestWithList(int k, int[] nums) {
            this.k = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            list.add(val);
            list.sort((Comparator.comparingInt(o -> o)));
            if (list.size() > k) {
                list.removeFirst();
            }
            return list.getFirst();
        }
    }
}

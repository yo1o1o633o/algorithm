package solution.solution_0347;

import javafx.util.Pair;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {4, 4, 5, 2, 2, 5, 3, 1, 3, 4, 4, 5, 1, 2, 3, 5, 5};
        System.out.println(Arrays.toString(topKFrequentWithFastSort(nums, 2)));
    }

    /**
     * 先统计每个元素出现的次数, 整合为一个Map
     * 将Map转成Pair容器,并使用List对次数进行排序
     * 排序后取前k个元素的原始元素值
     * */
    private static int[] topKFrequentWithList(int[] nums, int k) {
        Map<Integer, Integer> sum = new HashMap<>();
        for (int num : nums) {
            sum.put(num, sum.getOrDefault(num, 0) + 1);
        }
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sum.entrySet()) {
            Pair<Integer, Integer> pair = new Pair<>(entry.getValue(), entry.getKey());
            list.add(pair);
        }

        list.sort((o1, o2) -> o2.getKey() - o1.getKey());

        int[] res = new int[k];
        for (int j = 0; j < k; j++) {
            res[j] = list.get(j).getValue();
        }
        return res;
    }

    /**
     * 先统计每个元素出现的次数, 整合为一个Map
     * 利用最大堆对次数进行排序
     * */
    private static int[] topKFrequentWithPriority(int[] nums, int k) {
        Map<Integer, Integer> sum = new HashMap<>();
        for (int num : nums) {
            sum.put(num, sum.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());

        for (Map.Entry<Integer, Integer> entry : sum.entrySet()) {
            priorityQueue.offer(entry);
        }
        int[] res = new int[k];
        for (int j = 0; j < k; j++) {
            Map.Entry<Integer, Integer> poll = priorityQueue.poll();
            assert poll != null;
            res[j] = poll.getKey();
        }
        return res;
    }

    /**
     * 使用快排
     * */
    private static int[] topKFrequentWithFastSort(int[] nums, int k) {
        Map<Integer, Integer> sum = new HashMap<>();
        for (int num : nums) {
            sum.put(num, sum.getOrDefault(num, 0) + 1);
        }
        Map.Entry<Integer, Integer>[] arr = new Map.Entry[sum.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : sum.entrySet()) {
            arr[i] = entry;
            i++;
        }
        fastSort(arr, 0, arr.length - 1);
        int[] res = new int[k];
        for (int j = 0; j < k; j++) {
            res[j] = arr[j].getKey();
        }
        return res;
    }
    private static void fastSort(Map.Entry<Integer, Integer>[] nums, int l, int r) {
        if (l < r) {
            int p = sort(nums, l, r);
            fastSort(nums, l, p - 1);
            fastSort(nums, p + 1, r);
        }
    }
    private static int sort(Map.Entry<Integer, Integer>[] nums, int l, int r) {
        Random random = new Random();
        int i = random.nextInt(r - l + 1) + l;
        Map.Entry<Integer, Integer> temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;
        Map.Entry<Integer, Integer> p = nums[l];

        while (l < r) {
            while (l < r && nums[r].getValue() <= p.getValue()) {
                r--;
            }
            if (nums[r].getValue() > p.getValue()) {
                nums[l] = nums[r];
            }
            while (l < r && nums[l].getValue() >= p.getValue()) {
                l++;
            }
            if (nums[l].getValue() < p.getValue()) {
                nums[r] = nums[l];
            }
        }
        nums[l] = p;
        return l;
    }
}

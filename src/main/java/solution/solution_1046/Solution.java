package solution.solution_1046;

import java.util.PriorityQueue;

/**
 * 1046. 最后一块石头的重量
 *
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 */
public class Solution {
    public static void main(String[] args) {
        int[] stones = {7, 2};
        System.out.println(lastStoneWeightWithPriority(stones));
    }

    /**
     * 转成最大堆
     * 取出两次堆顶, 计算后放入堆中,直至堆中没有元素或者只有1个元素
     */
    private static int lastStoneWeightWithPriority(int[] stones) {
        if (stones.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) {
            max.offer(stone);
        }
        while (max.size() > 1) {
            int a = max.poll();
            if (max.size() > 0) {
                int b = max.poll();
                if (a > b) {
                    max.offer(a - b);
                }
            }
        }
        return max.isEmpty() ? 0 : max.poll();
    }
}

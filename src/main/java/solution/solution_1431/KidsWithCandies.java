package solution.solution_1431;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuai.yang
 */
public class KidsWithCandies {
    /**
     * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
     *
     * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
     * */
    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }

    /**
     * 两次循环. 先找到最大值. 然后加上额外的值循环比较
     * */
    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 找到最大值
        int max = 0;
        for (int candy : candies) {
            if (candy > max) {
                max = candy;
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    /**
     * 精简代码
     * */
    private static List<Boolean> kidsWithCandies1(int[] candies, int extraCandies) {
        // 找到最大值
        int max = 0;
        for (int candy : candies) {
            max = Math.max(candy, max);
        }
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            res.add(candy + extraCandies >= max);
        }
        return res;
    }
}

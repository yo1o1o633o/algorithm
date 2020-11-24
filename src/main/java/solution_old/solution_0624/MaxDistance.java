package solution_old.solution_0624;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shuai.yang
 */
public class MaxDistance {
    /**
     * 给定 m 个数组，每个数组都已经按照升序排好序了。现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b| 。你的任务就是去找到最大距离
     * */
    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(1, 2);
        List<Integer> list2 = Arrays.asList(-1, 3);
        List<Integer> list3 = Arrays.asList(1, 2, 3);
        arrays.add(list1);
        arrays.add(list2);
        arrays.add(list3);
        System.out.println(maxDistance(arrays));
        System.out.println(maxDistance1(arrays));
    }

    /**
     * 将最大值和最小值保存起来. 双重循环进行判断
     * */
    private static int maxDistance(List<List<Integer>> arrays) {
        List<Integer> max = new ArrayList<>();
        List<Integer> min = new ArrayList<>();
        for (List<Integer> array : arrays) {
            max.add(array.get(array.size() - 1));
            min.add(array.get(0));
        }
        int res = 0;
        for (int i = 0; i < max.size(); i++) {
            for (int j = 0; j < min.size(); j++) {
                if (i == j) {
                    continue;
                }
                res = Math.max(max.get(i) - min.get(j), res);
            }
        }
        return res;
    }

    /**
     * 线性执行. 先保存第一个数组, 然后从第二个数组开始取出最大最小值进行计算. 同时更新最大最小值和最终结果
     * */
    private static int maxDistance1(List<List<Integer>> arrays) {
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);
        int res = 0;
        for (int i = 1; i < arrays.size(); i++) {
            int tempMax = arrays.get(i).get(arrays.get(i).size() - 1);
            int tempMin = arrays.get(i).get(0);
            int tempNum = Math.max(Math.abs(tempMax - min), Math.abs(max - tempMin));
            if (tempNum > res) {
                res = tempNum;
            }
            max = Math.max(max, tempMax);
            min = Math.min(min, tempMin);
        }
        return res;
    }
}

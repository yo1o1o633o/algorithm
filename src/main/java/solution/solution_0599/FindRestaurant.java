package solution.solution_0599;

import java.util.*;

/**
 * @author shuai.yang
 */
public class FindRestaurant {
    /**
     * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
     *
     * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
     * */
    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Tapioca Express", "Shogun", "Hungry Hunter Steakhouse", "Burger King"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
        System.out.println(Arrays.toString(findRestaurant1(list1, list2)));
    }

    /**
     * hash表保存第一个数组
     * 判断第二个数组. 如果在其中, 那么计算索引. 保存较小的索引.
     * 如果索引相等那么添加保存
     * */
    private static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int count = map.get(list2[i]) + i;
                if (count < min) {
                    min = count;
                    list = new ArrayList<>();
                    list.add(list2[i]);
                } else if (count == min) {
                    list.add(list2[i]);
                }
            }
        }
        String[] res = new String[list.size()];
        return list.toArray(res);
    }

    /**
     * 优化下代码. 不在map里的就删掉. 提高下次判断的速度
     * */
    private static String[] findRestaurant1(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (!map.containsKey(list2[i])) {
                map.remove(list2[i]);
                continue;
            }
            int count = map.get(list2[i]) + i;
            if (count < min) {
                min = count;
                list = new ArrayList<>();
                list.add(list2[i]);
            } else if (count == min) {
                list.add(list2[i]);
            }
        }
        String[] res = new String[list.size()];
        return list.toArray(res);
    }
}

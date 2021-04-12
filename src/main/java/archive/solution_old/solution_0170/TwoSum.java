package archive.solution_old.solution_0170;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuai.yang
 */
public class TwoSum {
    /**
     * 用hashMap来存储添加得元素.
     * */
    private Map<Integer, Integer> nums = null;

    public TwoSum() {
        nums = new HashMap<>();
    }

    public void add(int number) {
        nums.put(number, nums.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> num : nums.entrySet()) {
            Integer res = value - num.getKey();
            if (!res.equals(num.getKey())) {
                if (nums.containsKey(res)) {
                    return true;
                }
            } else {
                if (num.getValue() > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

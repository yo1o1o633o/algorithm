package solution_old.solution_0170;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shuai.yang
 */
public class TwoSum1 {
    /**
     * 维系两个set集合. 另一个集合保存重复的元素
     * 用来解决相同值的判断
     * */
    private Set<Integer> all;
    private Set<Integer> dup;

    public TwoSum1() {
        all = new HashSet<>();
        dup = new HashSet<>();
    }

    public void add(int number) {
        if (all.contains(number)) {
            dup.add(number);
        } else {
            all.add(number);
        }
    }

    public boolean find(int value) {
        for (Integer num : all) {
            int target = value - num;
            if (target == num && dup.contains(value - num)) {
                return true;
            }
            if (target != num && all.contains(value - num)) {
                return true;
            }
        }
        return false;
    }
}

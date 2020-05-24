package solution.solution_0003;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shuai.yang
 */
public class LengthOfLongestSubstring {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * */
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring2(s));
    }

    /**
     * 双循环. 出现重复字符串进一位继续. 保存最大长度值
     * */
    private static int lengthOfLongestSubstring(String s) {
        int num = 0;
        Set<Character> set = new HashSet<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            for (int j = i; j < c.length; j++) {
                if (set.contains(c[j])) {
                    break;
                }
                set.add(c[j]);
            }
            int m = set.size();
            if (m > num) {
                num = m;
            }
            set = new HashSet<>();
        }
        return num;
    }

    /**
     * 窗口移动
     * 维持两个指针
     * 一个为起始位， 一个用于循环计数
     * 如果发现有相同的字符， 那么起始位移动。否则计数累计
     * */
    private static int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}

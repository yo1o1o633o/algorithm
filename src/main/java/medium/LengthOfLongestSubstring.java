package medium;

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
}

package solution.solution_0409;

import java.util.*;

/**
 * @author shuai.yang
 */
public class LongestPalindrome {
    /**
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     *
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     * */
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome1(s));
        System.out.println(longestPalindrome2(s));
    }

    /**
     * 维护一个hashMap. 如果遇到两个同样的字母就长度+2. 最后如果map不为空, +1 表示奇数个长度字符串的中间位
     * */
    private static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                count += 2;
                map.remove(s.charAt(i));
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        if (!map.isEmpty()) {
            count++;
        }
        return count;
    }

    /**
     * 换成set集合
     * */
    private static int longestPalindrome1(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                count += 2;
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }
        if (!set.isEmpty()) {
            count++;
        }
        return count;
    }

    /**
     * 先将所有的字符都放入字母数组中, 相同的字母元素+1
     * 次数数组中保存了每个字母的出现次数
     * 因为回文串中最多只能有1个奇数次的字母. 其他都是偶数次的
     * 那么统计奇数次的字母的个数.
     * 如果为0, 那么表示原字符串中所有字母都是成对的. 直接返回即可
     * 否则减去奇数次字母的个数. 最后再+1 即可
     * */
    private static int longestPalindrome2(String s) {
        int[] words = new int[128];
        for (char c : s.toCharArray()) {
            words[c]++;
        }
        int count = 0;
        // 奇数次字符的个数
        for (int w : words) {
            count += w % 2;
        }
        // 如果奇数次字符为0个.那么返回s的长度. 否则减去他
        return count == 0 ? s.length() : s.length() - count + 1;
    }
}

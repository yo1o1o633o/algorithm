package archive.solution;

import java.util.*;

/**
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * @author shuai.yang
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        String s = "cc";
        System.out.println(firstUniqCharWithIndexFunction(s));
    }

    /**
     * 最快
     * 遍历26个字母. 利用indexOf和lastIndexOf方法. 如果当前索引即时最后一个索引证明当前字母只有1个
     * 每次更新最小值即是结果
     * */
    private static int firstUniqCharWithIndexFunction(String s) {
        int index = -1;
        for (int i = 'a'; i <= 'z'; i++) {
            int ch = s.indexOf(i);
            if (ch != -1 && ch == s.lastIndexOf(i)) {
                index = (index == -1 || index > ch) ? ch : index;
            }
        }
        return index;
    }

    /**
     * 利用数组保存每个字母的出现次数
     * 二次遍历
     * 第二次遍历当第一次碰到出现1次的字母时返回
     * */
    private static int firstUniqCharWithArray(String s) {
        char[] chars = s.toCharArray();
        int[] words = new int[26];
        for (char c : chars) {
            words[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (words[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 利用Hash表保存每个字母的出现次数
     * 二次遍历
     * 第二次遍历当第一次碰到出现1次的字母时返回
     * */
    private static int firstUniqCharWithHash(String s) {
        if ("".equals(s) || s == null) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}

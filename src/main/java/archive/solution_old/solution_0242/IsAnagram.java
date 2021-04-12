package archive.solution_old.solution_0242;

import java.util.Arrays;

/**
 * @author shuai.yang
 */
public class IsAnagram {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * */
    public static void main(String[] args) {
        String s = "a";
        String t = "ab";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram1(s, t));
    }

    /**
     * 用字母数组来保存每个字符
     * s字符串往里加  t字符串向里减
     * 如果字母数组有不为0的即表示出现了不同情况
     * */
    private static boolean isAnagram(String s, String t) {
        int[] word = new int[26];
        for (int i = 0; i < s.length(); i++) {
            word[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            word[t.charAt(i) - 'a']--;
        }
        for (int value : word) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用java工具类排序比较
     * */
    private static boolean isAnagram1(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        s = String.valueOf(a);
        t = String.valueOf(b);
        return s.equals(t);
    }
}

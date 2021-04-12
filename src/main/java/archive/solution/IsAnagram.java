package archive.solution;

import java.util.Arrays;

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * @author shuai.yang
 */
public class IsAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagramWithSort(s, t));
    }

    /**
     * 利用排序, 对比两个排序后的数组是否相等
     * String.valueOf(sChar).equals(String.valueOf(tChar)); 比Arrays.equals(sChar, tChar);快
     * */
    private static boolean isAnagramWithSort(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return String.valueOf(tChar).equals(String.valueOf(sChar));
    }

    /**
     * 利用数组, 对每个字母进行++和--. 最终数组如果还有大于0的元素,代表不同
     * */
    private static boolean isAnagramWithArray(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] words = new int[26];
        for (int i = 0; i < s.length(); i++) {
            words[s.charAt(i) - 'a']++;
            words[t.charAt(i) - 'a']--;
        }
        for (int w : words) {
            if (w > 0) {
                return false;
            }
        }
        return true;
    }
}

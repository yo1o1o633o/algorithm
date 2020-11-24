package solution_old.solution_0290;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuai.yang
 */
public class WordPattern {
    /**
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     *
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     * */
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(wordPattern(pattern, str));
        System.out.println(wordPattern1(pattern, str));
    }

    /**
     * 两个hash表. 将一个单词作为一个整体
     * */
    private static boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> words = new HashMap<>();
        String[] s = str.split(" ");
        if (s.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i)) && !map.get(pattern.charAt(i)).equals(s[i])) {
                return false;
            }
            if (words.containsKey(s[i]) && !words.get(s[i]).equals(pattern.charAt(i))) {
                return false;
            }
            map.put(pattern.charAt(i), s[i]);
            words.put(s[i], pattern.charAt(i));
        }
        return true;
    }

    /**
     * 利用map put操作的返回值进行判断
     * */
    private static boolean wordPattern1(String pattern, String str) {
        String[] s = str.split(" ");
        Map map = new HashMap();
        if (s.length != pattern.length()) {
            return false;
        }
        for (Integer i = 0; i < s.length; i++) {
            if (map.put(pattern.charAt(i), i) != map.put(s[i], i)) {
                return false;
            }
        }
        return true;
    }
}

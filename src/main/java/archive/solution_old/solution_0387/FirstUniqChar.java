package archive.solution_old.solution_0387;

import java.util.HashMap;

/**
 * @author Yang
 */
public class FirstUniqChar {
    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * */
    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar2("loveleetcode"));
        System.out.println(firstUniqChar3("loveleetcode"));
        System.out.println(firstUniqChar4("loveleetcode"));
        System.out.println(firstUniqChar5("loveleetcode"));
    }

    /**
     * 暴力循环
     * */
    private static int firstUniqChar(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            boolean f = false;
            for (int j = 0; j < c.length; j++) {
                if (i != j && c[i] == c[j]) {
                    f = true;
                    break;
                }
            }
            if (!f) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 将字符串中字符的出现次数保存到一个hashmap里. 然后遍历字符串进行判断. 碰到次数是1的就是第一次的
     * */
    private static int firstUniqChar2(String s) {
        HashMap<Character, Integer> maps = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (maps.containsKey(s.charAt(i))) {
                maps.put(s.charAt(i), maps.get(s.charAt(i)) + 1);
                continue;
            }
            maps.put(s.charAt(i), 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (maps.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 用int[]数组
     * */
    private static int firstUniqChar3(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'a';
            if (count[a] != 0) {
                count[a] = count[a] + 1;
                continue;
            }
            count[a] = 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 用int[]数组
     * */
    private static int firstUniqChar4(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 反向遍历. 直接遍历26个字母
     * */
    private static int firstUniqChar5(String s) {
        int res = -1;
        for (char i = 'a'; i <= 'z'; i++) {
            int index = s.indexOf(i);
            if (index != -1 && index == s.lastIndexOf(i)) {
                res = (res == -1 || res > index) ? index : res;
            }
        }
        return res;
    }
}

package solution_old.solution_0389;

/**
 * @author shuai.yang
 */
public class FindTheDifference {
    /**
     * 给定两个字符串 s 和 t，它们只包含小写字母。
     *
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     *
     * 请找出在 t 中被添加的字母。
     * */
    public static void main(String[] args) {
        String s = "";
        String t = "y";
        System.out.println(findTheDifference(s, t));
        System.out.println(findTheDifference1(s, t));
        System.out.println(findTheDifference2(s, t));
        System.out.println(findTheDifference3(s, t));
    }

    /**
     * 用字母对应数组来保存要查询的字符串
     * 先增后删. 最后剩下的就是多出的字符
     * */
    private static char findTheDifference(String s, String t) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        int[] words = new int[26];
        for (int i = 0; i < s.length(); i++) {
            words[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            words[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i] != 0) {
                return str.charAt(i);
            }
        }
        return ' ';
    }

    /**
     * 相同的字符异或操作会得0
     * 那么最后得结果就是添加得字符
     * */
    private static char findTheDifference1(String s, String t) {
        char r = 0;
        for (int i = 0; i < s.length(); i++) {
            r ^= s.charAt(i) ^ t.charAt(i);
        }
        r ^= t.charAt(t.length() - 1);
        return r;
    }

    /**
     * 取总数
     * s字符串每个字符加起来得和是一个值
     * t也一样
     * t - s 就是多余字符的对应ascii码
     * */
    private static char findTheDifference2(String s, String t) {
        int sLen = 0;
        for (int i = 0; i < s.length(); i++) {
            sLen += (int) s.charAt(i);
        }
        int tLen = 0;
        for (int i = 0; i < t.length(); i++) {
            tLen += (int) t.charAt(i);
        }
        return (char) (tLen - sLen);
    }

    /**
     * 一波循环 加减操作.
     * */
    private static char findTheDifference3(String s, String t) {
        int len = 0;
        for (int i = 0; i < t.length(); i++) {
            if (i < s.length()) {
                len -= s.charAt(i);
            }
            len += t.charAt(i);
        }
        return (char) len;
    }
}

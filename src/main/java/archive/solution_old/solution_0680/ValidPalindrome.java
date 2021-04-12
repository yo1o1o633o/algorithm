package archive.solution_old.solution_0680;

/**
 * @author shuai.yang
 */
public class ValidPalindrome {
    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     * */
    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgml cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu lmgmqfvnbgtapekouga";
        System.out.println(validPalindrome(s));
    }

    /**
     * 当第一个和最后一个不相同时, 对剩下的字符串右移和左移操作, 分别判断.
     * */
    private static boolean validPalindrome(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0, j = cs.length - 1; i < s.length() / 2; i++, j--) {
            if (cs[i] != cs[j]) {
                String t = s.substring(i + 1, j + 1);
                String g = s.substring(i, j);
                return check(t) || check(g);
            }
        }
        return true;
    }

    private static boolean check(String s) {
        char[] t = s.toCharArray();
        for (int k = 0, v = t.length - 1; k < t.length / 2; k++, v--) {
            if (t[k] != t[v]) {
                return false;
            }
        }
        return true;
    }
}

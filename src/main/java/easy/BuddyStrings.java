package easy;

/**
 * @author Yang
 */
public class BuddyStrings {
    /**
     * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
     * */
    public static void main(String[] args) {
        String a = "aaaaaaabc";
        String b = "aaaaaaacb";
        System.out.println(buddyStrings(a, b));
    }

    private static boolean buddyStrings(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        /**
         * a == b时, 是否有重复字母, 如果有那么返回真.
         * */
        if (a.equals(b)) {
            int[] count = new int[26];
            for (int i = 0; i < a.length(); i++) {
                count[a.charAt(i) - 'a']++;
            }
            for (int c : count) {
                if (c > 1) {
                    return true;
                }
            }
            return false;
        } else {
            int k = -1;
            int v = -1;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (k == -1) {
                        k = i;
                    } else if (v == -1) {
                        v = i;
                    } else {
                        return false;
                    }
                }
            }
            return (v != -1 && a.charAt(k) == b.charAt(v) && a.charAt(v) == b.charAt(k));
        }
    }
}

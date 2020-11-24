package solution_old.solution_0266;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shuai.yang
 */
public class CanPermutePalindrome {
    /**
     * 给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
     * */
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(canPermutePalindrome(s));
        System.out.println(canPermutePalindrome1(s));
    }

    /**
     * set集合  如果是回文 那么每个字符都会是双份的. 最多只会有一个单份的字符
     * 如果在集合内就把集合内原来的也删掉. 不存在就放进去
     * 最后判断集合大小. 1个以上元素就不是回文串
     * */
    private static boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }
        return set.size() <= 1;
    }

    /**
     * 字符数组形式
     * 判断是否只有1个奇数
     * */
    private static boolean canPermutePalindrome1(String s) {
        int[] words = new int[128];
        for (int i = 0; i < s.length(); i++) {
            words[s.charAt(i)]++;
        }
        boolean f = false;
        for (int word : words) {
            if (word % 2 != 0) {
                if (f) {
                    return false;
                }
                f = true;
            }
        }
        return true;
    }
}

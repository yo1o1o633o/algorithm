package solution_0917;

import java.util.Stack;

/**
 * @author shuai.yang
 */
public class ReverseOnlyLetters {
    /**
     * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
     * */
    public static void main(String[] args) {
        String s = "AaW;c?[";
        System.out.println(reverseOnlyLetters(s));
        System.out.println(reverseOnlyLetters2(s));
    }

    /**
     * 双指针, 遇到非字母就继续前进, 都是字母就调换
     * */
    private static String reverseOnlyLetters(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        int j = c.length - 1;
        while (i < j) {
            if (!isWord(c[i])) {
                i++;
                continue;
            }
            if (!isWord(c[j])) {
                j--;
                continue;
            }
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(c);
    }
    private static boolean isWord(char c) {
        int min = c - 'a';
        if (0 <= min && min < 26) {
            return true;
        }
        int max = c - 'A';
        return 0 <= max && max < 26;
    }

    /**
     * 用栈操作
     * */
    private static String reverseOnlyLetters2(String s) {
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (isWord(c[i])) {
                stack.add(c[i]);
            }
        }
        int j = 0;
        while (j < c.length) {
            if (!isWord(c[j])) {
                j++;
                continue;
            }

            c[j] = stack.pop();
            j++;
        }
        return String.valueOf(c);
    }
}

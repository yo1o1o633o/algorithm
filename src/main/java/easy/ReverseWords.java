package easy;

/**
 * @author shuai.yang
 */
public class ReverseWords {
    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *
     * 示例 1:
     *
     * 输入: "Let's take LeetCode contest"
     * 输出: "s'teL ekat edoCteeL tsetnoc" 
     * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     * */
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
        System.out.println(reverseWords2(s));
        System.out.println(reverseWords3(s));
    }

    /**
     * 拆分字符串为数组, 对每个元素倒序拼接
     * */
    private static String reverseWords(String s) {
        if ("".equals(s)) {
            return s;
        }
        StringBuilder r = new StringBuilder();
        String[] str = s.split(" ");
        for (String c : str) {
            for (int i = c.length() - 1; i >= 0; i--) {
                r.append(c.charAt(i));
            }
            r.append(" ");
        }
        return r.toString().substring(0, r.length() - 1);
    }

    private static String reverseWords2(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (' ' != s.charAt(i)) {
                res.insert(0, s.charAt(i));
            } else {
                res.insert(0, " ");
            }
        }
        String[] str = res.toString().split(" ");
        StringBuilder r = new StringBuilder();
        for (int i = 0, j = str.length - 1; i < str.length / 2; i++, j--) {
            String temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
        for (String c : str) {
            r.append(c);
            r.append(" ");
        }
        return r.toString().substring(0, r.length() - 1);
    }

    /**
     * 反转整个字符串为字符数组. 碰到空格就拼接
     * */
    private static String reverseWords3(String s) {
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < c.length / 2; i++, j--) {
            char t = c[i];
            c[i] = c[j];
            c[j] = t;
        }
        StringBuilder r = new StringBuilder();
        StringBuilder n = new StringBuilder();
        for (char value : c) {
            if (value == ' ') {
                r.insert(0, " " + n);
                n = new StringBuilder();
            } else {
                n.append(value);
            }
        }
        r.insert(0, n);
        return r.toString();
    }
}

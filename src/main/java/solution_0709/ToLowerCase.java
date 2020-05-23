package solution_0709;

/**
 * @author Yang
 */
public class ToLowerCase {
    /**
     * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
     * */
    public static void main(String[] args) {
        String str = "HelLo";
        System.out.println(toLowerCase(str));
    }

    /**
     * 通过ASCII码进行判断
     * */
    private static String toLowerCase(String str) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) - 'A' >= 0 && str.charAt(i) - 'A' <= 26) {
                char c = (char) (str.charAt(i) + 32);
                s.append(c);
            } else {
                s.append(str.charAt(i));
            }
        }
        return s.toString();
    }
}

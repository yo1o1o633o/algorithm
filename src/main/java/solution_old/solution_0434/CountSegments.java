package solution_old.solution_0434;

/**
 * @author Yang
 */
public class CountSegments {
    /**
     * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
     *
     * 请注意，你可以假定字符串里不包括任何不可打印的字符。
     * */
    public static void main(String[] args) {
        String s = "  Hello,   my name is John                ";
        System.out.println(countSegments(s));
        System.out.println(countSegments2(s));
    }

    /**
     * 碰到空格, 计数加1
     * */
    private static int countSegments(String s) {
        s = s.trim();
        if ("".equals(s)) {
            return 0;
        }
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (s.charAt(i - 1) == ' ') {
                    continue;
                }
                count++;
            }
        }
        return count;
    }


    /**
     * 碰到前一个字符是空格的, 加1
     * */
    private static int countSegments2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean exist = (i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ';
            if (exist) {
                count++;
            }
        }
        return count;
    }
}

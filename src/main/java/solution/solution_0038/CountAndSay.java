package solution.solution_0038;

/**
 * @author Yang
 */
public class CountAndSay {
    /**
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
     *
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     *
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
     *
     * 注意：整数序列中的每一项将表示为一个字符串。
     *
     * 题目含义解释
     * 1 为起始.  11就是前边有1个1(1)   21就是前边的数时2个1(11)   1211就是前边有1个2两个1(1[个]2[个]11)
     * */
    public static void main(String[] args) {
        System.out.println(countAndSay(3));
    }


    private static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String str = "11";
        for (int i = 2; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            int count = 1;
            for (int j = 0; j < str.length();j++) {
                char s = str.charAt(j);
                if (j == str.length() - 1) {
                    temp.append(count);
                    temp.append(s);
                    count = 1;
                } else {
                    char k = str.charAt(j + 1);
                    if (s == k) {
                        count++;
                    } else {
                        temp.append(count);
                        temp.append(s);
                        count = 1;
                    }
                }
            }
            str = temp.toString();
        }
        return str;
    }
}

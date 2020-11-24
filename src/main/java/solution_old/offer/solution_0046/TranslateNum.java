package solution_old.offer.solution_0046;

/**
 * @author shuai.yang
 */
public class TranslateNum {
    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * */
    public static void main(String[] args) {
        int num = 12258;
        System.out.println(translateNum(num));
    }

    /**
     * 动态规划. 递归
     * */
    private static int translateNum(int num) {
        if (num == 0) {
            return 1;
        }
        return helper(num);
    }
    private static int helper(int num) {
        if (num < 10) {
            return 1;
        }
        if (num % 100 < 26 && num % 100 > 9) {
            return helper(num / 10) + helper(num / 100);
        } else {
            return helper(num / 10);
        }
    }
}

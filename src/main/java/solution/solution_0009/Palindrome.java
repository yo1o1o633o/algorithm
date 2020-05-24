package solution.solution_0009;

/**
 * @author Yang
 */
public class Palindrome {
    /**
     * 回文数
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * */
    public static void main(String[] args) {
        boolean res = isPalindrome(1221);
        System.out.println(res);
    }

    /**
     * 模运算, 数字取反返回和原数比较
     * */
    private static boolean isPalindrome(int num) {
        if (num < 0 || (num % 10 == 0 && num != 0)) {
            return false;
        }
        long b = num;
        long a = 0;
        while (num != 0) {
            int pop = num % 10;
            num /= 10;
            a = a * 10 + pop;
        }
        return a == b;
    }
}

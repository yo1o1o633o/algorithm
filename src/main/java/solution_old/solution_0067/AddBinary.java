package solution_old.solution_0067;

/**
 * @author Yang
 */
public class AddBinary {
    /**
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     *
     * 输入为 非空 字符串且只包含数字 1 和 0。
     * */
    public static void main(String[] args) {
        String a = "1111";
        String b = "11";
        System.out.println(addBinary(a, b));
        System.out.println(addBinary2(a, b));
    }

    /**
     * Math工具类
     * 问题: 传入字符串长度受限, 转Integer有长度限制, Long也会溢出
     * 性能问题.
     * */
    private static String addBinary(String a, String b) {
        // 将字符串转换成二进制计算后转成二进制字符串
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    /**
     * 从后开始两两计算, 追加到字符串后. 最后翻转字符串即可
     * */
    private static String addBinary2(String a, String b) {
        StringBuilder s = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            s.append(sum % 2);
            carry = sum / 2;
        }
        s.append(carry == 1 ? carry : "");
        return s.reverse().toString();
    }
}

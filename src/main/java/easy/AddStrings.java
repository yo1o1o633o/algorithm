package easy;

import java.util.HashMap;

/**
 * @author Yang
 */
public class AddStrings {
    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     *
     * 注意：
     *
     * num1 和num2 的长度都小于 5100.
     * num1 和num2 都只包含数字 0-9.
     * num1 和num2 都不包含任何前导零。
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
     * */
    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "9";
        System.out.println(addStrings(num1, num2));
        System.out.println(addStrings2(num1, num2));
    }

    /**
     * 错误解法.  按位相加无法实现. 因为有特殊要求位数会小于5100个字符. 即数据类型会溢出
     * */
    private static String addStrings(String num1, String num2) {
        if ("".equals(num1)) {
            return num2;
        }
        if ("".equals(num2)) {
            return num1;
        }
        HashMap<Character, Integer> maps = new HashMap<>();
        maps.put('0', 0);
        maps.put('1', 1);
        maps.put('2', 2);
        maps.put('3', 3);
        maps.put('4', 4);
        maps.put('5', 5);
        maps.put('6', 6);
        maps.put('7', 7);
        maps.put('8', 8);
        maps.put('9', 9);
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        long sum = 0;
        int count = 0;
        while (i >= 0 || j >= 0) {
            int a = 0;
            if (i >= 0) {
                a = maps.get(num1.charAt(i));
            }
            int b = 0;
            if (j >= 0) {
                b = maps.get(num2.charAt(j));
            }
            int n = a + b;
            sum = sum + (long) (n * Math.pow(10, count));
            i--;
            j--;
            count++;
        }
        return sum + "";
    }

    /**
     * 只能按字符串对其进行操作
     * */
    private static String addStrings2(String num1, String num2) {
        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();
        int i = a.length - 1;
        int j = b.length - 1;
        int count = 0;
        StringBuilder res = new StringBuilder();
        while (true) {
            int aa = 0;
            if (i >= 0) {
                aa = a[i] - '0';
                i--;
            }
            int bb = 0;
            if (j >= 0) {
                bb = b[j] - '0';
                j--;
            }
            int c = aa + bb + count;
            if (c >= 10) {
                c = c % 10;
                count = 1;
            } else {
                count = 0;
            }
            res.insert(0, c);
            if (i < 0 && j < 0) {
                if (count > 0) {
                    res.insert(0, 1);
                }
                break;
            }
        }
        return res.toString();
    }
}

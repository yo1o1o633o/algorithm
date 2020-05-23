package solution_0541;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yang
 */
public class ReverseStr {
    /**
     * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
     * */
    public static void main(String[] args) {
        String a = "krmyfshbspcgtesxnnljhfursyissjnsocgdhgfxubewllxzqhpasguvlrxtkgatzfybprfmmfithphckksnvjkcvnsqgsgosfxc";
        int b = 20;
        System.out.println(reverseStr(a, b));
        System.out.println(reverseStr2(a, b));
        System.out.println(reverseStr3(a, b));
    }

    /**
     * 根据条件拆分原字符串为数组, 进行分别判断后组装
     * */
    private static String reverseStr(String s, int k) {
        if (k == 1) {
            return s;
        }
        int last = s.length() % (2 * k);
        String sc = s.substring(0, s.length() - last);
        List<String> str = new ArrayList<>();
        for (int i = 0; i < sc.length() / (2 * k); i++) {
            str.add(s.substring(i * 2 * k, 2 * k * (i + 1)));
        }
        str.add(s.substring(s.length() - last));
        StringBuilder res = new StringBuilder();
        for (String r : str) {
            if (r.length() == (2 * k) || (r.length() < (2 * k) && r.length() >= k)) {
                char[] rs = r.substring(0, k).toCharArray();
                c(res, rs);
                res.append(r.substring(k));
            }
            if (r.length() < k) {
                char[] rs = r.toCharArray();
                c(res, rs);
            }
        }
        return res.toString();
    }


    private static void c(StringBuilder res, char[] rs) {
        for (int i = 0, j = rs.length - 1; i < rs.length / 2; i++, j--) {
            char temp = rs[i];
            rs[i] = rs[j];
            rs[j] = temp;
        }
        for (char e : rs) {
            res.append(e);
        }
    }

    /**
     * 直接循环截取. 截取指定长度开始判断和交换处理
     * */
    private static String reverseStr2(String s, int k) {
        StringBuilder res = new StringBuilder();
        while (s.length() > 0) {
            String temp;
            if (s.length() >= 2 * k) {
                temp = s.substring(0, 2 * k);
            } else {
                temp = s;
            }
            if (temp.length() == (2 * k) || (temp.length() < (2 * k) && temp.length() >= k)) {
                char[] rs = temp.substring(0, k).toCharArray();
                c(res, rs);
                res.append(temp.substring(k));
            }
            if (temp.length() < k) {
                char[] rs = temp.toCharArray();
                c(res, rs);
            }
            if (s.length() >= 2 * k) {
                s = s.substring(2 * k);
            } else {
                s = "";
            }
        }
        return res.toString();
    }

    /**
     * 整个转成字节数组
     * 以2k为步长进行循环
     * 每次循环的起始都是2k
     * 从2k起始循环到k+2k-1. 即前40个要进行换位, 只要换位0~19的索引位即可
     * */
    private static String reverseStr3(String s, int k) {
        char[] a = s.toCharArray();
        // 循环每次前进2 * k
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start;
            int j = Math.min(start + k - 1, a.length - 1);
            // 第一次循环 0 ~ 19
            // 第二次循环 40 ~ 59
            while (i < j) {
                char temp = a[i];
                a[i++] = a[j];
                a[j--] = temp;
            }
        }
        return new String(a);
    }
}

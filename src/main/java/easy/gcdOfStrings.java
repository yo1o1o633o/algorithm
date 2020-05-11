package easy;

public class gcdOfStrings {
    /**
     * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
     *
     * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
     *
     * BigInteger用不了， 所以要自己写求最大公因数
     * */
    public static void main(String[] args) {
        String str1 = "ABABAB";
        String str2 = "ABAB";
        System.out.println(gcdStrings(str1, str2));
        System.out.println(gcdStrings2(str1, str2));
    }

    /**
     * 取1个字符串拆分循环组装。 找到可以组成这个字符串的子串
     * 找到字串后再循环组装和另一个字符串对比
     * 最终保存长度最长的字串
     * */
    private static String gcdStrings(String str1, String str2) {
        String loopStr = str1.length() <= str2.length() ? str1 : str2;
        String authorStr = str1.length() > str2.length() ? str1 : str2;
        String res = "";
        for (int i = 1; i <= loopStr.length(); i++) {
            if (loopStr.length() % i != 0) {
                continue;
            }
            String temp = loopStr.substring(0, i);
            StringBuilder c = new StringBuilder();
            do {
                c.append(temp);
            } while (c.length() != loopStr.length());

            if (c.toString().equals(loopStr)) {
                StringBuilder c2 = new StringBuilder();
                do {
                    c2.append(temp);
                    if (c2.length() > authorStr.length()) {
                        break;
                    }
                } while (c2.length() != authorStr.length());
                if (c2.toString().equals(authorStr)) {
                    res = temp;
                }
            }
        }
        return res;
    }

    /**
     * 利用最大公约数
     * */
    private static String gcdStrings2(String str1, String str2) {
        Integer len1 = str1.length();
        Integer len2 = str2.length();
        String s = str1.substring(0, gcb(len1, len2));
        return check(s, str1) && check(s, str2) ? s : "";
    }
    /**
     * 辗转相除法取最大公因数  gcd(a,b) = gcd(b,a mod b)
     * a和b的最大公因数也等于  b和a%b的公因数。
     * */
    private static Integer gcb(Integer a, Integer b) {
        return a % b == 0 ? b : gcb(b, a % b);
    }
    private static boolean check(String s, String str) {
        StringBuilder c = new StringBuilder();
        do {
            c.append(s);
            if (c.length() > str.length()) {
                break;
            }
        } while (c.length() != str.length());
        return c.toString().equals(str);
    }

    /**
     * 交换定律
     * 如果存在最大公因数，那么直接取公因数位数即可
     * */
    private static String gcdStrings3(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcb(str1.length(), str2.length()));
    }
}

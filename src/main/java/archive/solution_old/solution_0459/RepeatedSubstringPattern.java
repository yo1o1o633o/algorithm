package archive.solution_old.solution_0459;

/**
 * @author Yang
 */
public class RepeatedSubstringPattern {
    /**
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
     * */
    public static void main(String[] args) {
        String s = "abcabcabc";
        System.out.println(repeatedSubstringPattern(s));
        System.out.println(repeatedSubstringPattern2(s));
    }

    /**
     * 循环判断. 字串必然小于等于字符串的一半长度. 如果成立, 字符串长度%字串长度为0.
     * 从二分之一开始循环判断. 当%运算为0时, 循环字串和原字符串进行对比. 相同即返回真
     * */
    private static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len / 2; i > 0; i--) {
            if (len % i == 0) {
                int l = len / i;
                StringBuilder sb = new StringBuilder();
                String temp = s.substring(0, i);
                for (int j = 0; j < l; j++) {
                    sb.append(temp);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 如果一个字符串可以由字串构成. 那么2个字符串拼接, 会有2*字串的个数组成
     * 例: abcabc 由abc构成. 那么  abcabcabcabc 就会由4个abc构成
     * 掐头去尾: bcabcabcab, 如果依然包含原字符串, 那么返回真
     * */
    private static boolean repeatedSubstringPattern2(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}

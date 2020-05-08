package easy;

public class CountBinarySubstrings {
    /**
     * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
     *
     * 重复出现的子串要计算它们出现的次数。
     * */
    public static void main(String[] args) {
        String s = "00110011";
        System.out.println(countBinarySubstrings(s));
        System.out.println(countBinarySubstrings2(s));
    }

    /**
     * 1. 将字符串拆分成数组. 元素为同一个字符的出现次数 00110011   [2,2,2,2]
     * 2. 第一个2和第二个2  只有两种可能  0011 或  1100  不管如果组装. 都是2个 即两个数的最小值
     * */
    private static int countBinarySubstrings(String s) {
        int[] group = new int[s.length()];
        int j = 0;
        group[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                group[++j]++;
            } else {
                group[j]++;
            }
        }
        int res = 0;
        for (int i = 1; i <= j; i++) {
            res += Math.min(group[i - 1], group[i]);
        }
        return res;
    }


    private static int countBinarySubstrings2(String s) {
        int res = 0;
        int prev = 0;
        // 后一个个数
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                res += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        res += Math.min(prev, cur);
        return res;
    }

}

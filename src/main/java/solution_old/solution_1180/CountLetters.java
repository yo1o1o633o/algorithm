package solution_old.solution_1180;

/**
 * @author shuai.yang
 */
public class CountLetters {
    /**
     * 给你一个字符串 S，返回只含 单一字母 的子串个数。
     * */
    public static void main(String[] args) {
        String s = "aaaaaaaaaa";
        System.out.println(countLetters(s));
    }

    /**
     * 循环计算. 当碰到不同字母时,使用数学计算公式计算.最后累加
     * 即分组计算  aaabbs   aaa  bb s 分别计算个数
     * */
    private static int countLetters(String s) {
        int count = 0;
        int i = 1;
        int t = 1;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                t++;
            } else {
                count += (t + 1) * t / 2;
                t = 1;
            }
            i++;
        }
        if (t > 0) {
            count += (t + 1) * t / 2;
        }
        return count;
    }
}

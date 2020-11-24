package solution_old.solution_0551;

/**
 * @author Yang
 */
public class CheckRecord {
    /**
     * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
     *
     * 'A' : Absent，缺勤
     * 'L' : Late，迟到
     * 'P' : Present，到场
     * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
     *
     * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
     * */
    public static void main(String[] args) {
        String s = "PPALLP";
        System.out.println(checkRecord(s));
        System.out.println(checkRecord2(s));
        System.out.println(checkRecord3(s));
    }

    /**
     * 循环计数, 累计A的次数. 满足条件就返回
     * */
    private static boolean checkRecord(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                num++;
            }
            if (s.contains("LLL") || num > 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkRecord2(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                num++;
            }
            if (i <= s.length() - 3 && s.charAt(i) == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
                return false;
            }
        }
        return num < 2;
    }

    /**
     * 正则匹配
     * 3个L的子串或者有2个A
     * */
    private static boolean checkRecord3(String s) {
        return !s.matches(".*(A.*A|LLL).*");
    }
}

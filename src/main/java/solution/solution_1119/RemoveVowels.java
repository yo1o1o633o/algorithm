package solution.solution_1119;

/**
 * @author shuai.yang
 */
public class RemoveVowels {
    /**
     * 给你一个字符串 S，请你删去其中的所有元音字母（ 'a'，'e'，'i'，'o'，'u'），并返回这个新字符串。
     * */
    public static void main(String[] args) {
        String s = "leetcodeisacommunityforcoders";
        System.out.println(removeVowels(s));
        System.out.println(removeVowels1(s));
    }

    /**
     * 循环判断
     * */
    private static String removeVowels(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    break;
                default:
                    res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    /**
     * 正则
     * */
    private static String removeVowels1(String s) {
        return s.replaceAll("[aeiou]", "");
    }
}

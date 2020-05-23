package solution_0125;

/**
 * @author Yang
 */
public class IsPalindrome {
    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * */
    public static void main(String[] args) {
        String s = "aa";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome2(s));
    }

    /**
     * 大写转小写, 反转字符串
     * */
    private static boolean isPalindrome(String s) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                String low = String.valueOf(s.charAt(i)).toLowerCase();
                a.append(low);
                b.insert(0, low);
            }
        }
        return a.toString().equals(b.toString());
    }

    /**
     * 双指针, 一个从后向前, 一个从前向后
     * */
    private static boolean isPalindrome2(String s) {
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                a.append(String.valueOf(s.charAt(i)).toLowerCase());
            }
        }
        s = a.toString();
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            String lowA = String.valueOf(s.charAt(i)).toLowerCase();
            String lowB = String.valueOf(s.charAt(j)).toLowerCase();
            if (!lowA.equals(lowB)) {
                return false;
            }
        }
        return true;
    }
}

package solution;

/**
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * */
public class IsPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindromeWithDoublePoint(s));
    }

    /**
     * 利用String函数翻转方法
     * 先将字母和数字提取出来组成新的字符串， 翻转后和本身比较。
     * 放入时将字母转成小写字母。
     * */
    private static boolean isPalindromeWithReverse(String s) {
        StringBuilder oldValue = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char r = s.charAt(i);
            if (Character.isLetterOrDigit(r)) {
                oldValue.append(Character.toLowerCase(r));
            }
        }
        StringBuffer newValue = new StringBuffer(oldValue.toString()).reverse();
        return newValue.toString().equals(oldValue.toString());
    }

    /**
     * 利用双指针
     * 当前后都是数字字母时， 都转换成大写进行比较
     * */
    private static boolean isPalindromeWithDoublePoint(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        char[] sc = s.toCharArray();
        while (i < j) {
            // 循环过滤前边非字母数字
            while (i < j && (sc[i] < 'a' || sc[i] > 'z') && (sc[i] < '0' || sc[i] > '9') && (sc[i] < 'A' || sc[i] > 'Z')) {
                i++;
            }
            // 循环过滤后边非字母数字
            while (i < j && (sc[j] < 'a' || sc[j] > 'z') && (sc[j] < '0' || sc[j] > '9') && (sc[j] < 'A' || sc[j] > 'Z')) {
                j--;
            }
            // ASCII小写字母在大写字母后边, 如果比大写Z大,证明是小写字母. -'a'+'A'就是切换成对应的大写字母
            int a = sc[i] > 'Z' ? sc[i] - 'a' + 'A' : sc[i];
            int b = sc[j] > 'Z' ? sc[j] - 'a' + 'A' : sc[j];
            if (a != b) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

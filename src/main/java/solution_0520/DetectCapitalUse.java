package solution_0520;

/**
 * @author Yang
 */
public class DetectCapitalUse {
    /**
     * 给定一个单词，你需要判断单词的大写使用是否正确。
     *
     * 我们定义，在以下情况时，单词的大写用法是正确的：
     *
     * 全部字母都是大写，比如"USA"。
     * 单词中所有字母都不是大写，比如"leetcode"。
     * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
     * 否则，我们定义这个单词没有正确使用大写字母。
     * */
    public static void main(String[] args) {
        String s = "leetCode";
        System.out.println(detectCapitalUse(s));
        System.out.println(detectCapitalUse2(s));
    }

    /**
     * 直接取前两个字符
     * 如果第一个是大写, 那么后边只能全是大写或者全是小写
     * 如果第一个是小写, 那么后边只能全是小写
     * 用ASCII进行大小判断
     * */
    private static boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
            return true;
        }
        char a = word.charAt(0);
        char b = word.charAt(1);
        for (int i = 1; i < word.length(); i++) {
            // 第一个大写
            if (a >= 65 && a <= 90) {
                // 第二个大写
                if (b >= 65 && b <= 90) {
                    // 后边有小写false
                    if (word.charAt(i) < 65 || word.charAt(i) > 90) {
                        return false;
                    }
                } else {
                    if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
                        return false;
                    }
                }
            } else {
                // 第一个字母小写, 后边有大写的. false
                if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 个数统计.
     * 如果大写开头.只能是1个或者length个否则为0个
     * */
    private static boolean detectCapitalUse2(String word) {
        char a = word.charAt(0);
        int num = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
                num++;
            }
        }
        // 第一个大写
        if (a >= 65 && a <= 90) {
            return num <= 1 || num >= word.length();
        } else {
            return num <= 0;
        }
    }
}

package solution.solution_0408;

/**
 * @author shuai.yang
 */
public class ValidWordAbbreviation {
    /**
     * 给一个 非空 字符串 s 和一个单词缩写 abbr ，判断这个缩写是否可以是给定单词的缩写。
     *
     * 字符串 "word" 的所有有效缩写为：
     *
     * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
     * 注意单词 "word" 的所有有效缩写仅包含以上这些。任何其他的字符串都不是 "word" 的有效缩写。 
     * */
    public static void main(String[] args) {
        String word = "a";
        String abbr = "01";
        System.out.println(validWordAbbreviation(word, abbr));
        System.out.println(validWordAbbreviation1(word, abbr));
    }

    /**
     * 双指针, 同时控制两个字符串
     * 注意: 0开头不是合法数字. 比如 a02c 这样的直接返回false
     * 而 a20c  中的20是合法的
     * */
    private static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        String temp = "";
        while (i <= abbr.length() - 1) {
            if (j > word.length() - 1) {
                return false;
            }
            if (Character.isLowerCase(abbr.charAt(i))) {
                if (abbr.charAt(i) != word.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j++;
                }
                continue;
            }
            if (Character.isDigit(abbr.charAt(i))) {
                temp += abbr.charAt(i);
                if (!(i != abbr.length() - 1 && Character.isDigit(abbr.charAt(i + 1)))) {
                    if (temp.charAt(0) == '0') {
                        return false;
                    }
                    j += Integer.parseInt(temp);
                    temp = "";
                }
                i++;
            }
        }

        return j == word.length();
    }

    private static boolean validWordAbbreviation1(String word, String abbr) {
        int wordLen = word.length();
        int len = abbr.length();

        int abbrLen = 0;
        int num = 0;
        for (int i = 0; i < len; ++i) {
            if (abbr.charAt(i) >= 'a' && abbr.charAt(i) <= 'z') {
                abbrLen += num + 1;
                num = 0;
                if (abbrLen > wordLen || abbr.charAt(i) != word.charAt(abbrLen - 1)) {
                    return false;
                }
            } else {
                if (num == 0 && abbr.charAt(i) == '0') {
                    return false;
                }
                num = num * 10 + (abbr.charAt(i) - '0');
            }
        }
        return abbrLen + num == wordLen;
    }
}

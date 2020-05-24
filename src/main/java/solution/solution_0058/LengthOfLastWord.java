package solution.solution_0058;

/**
 * @author Yang
 */
public class LengthOfLastWord {
    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
     *
     * 如果不存在最后一个单词，请返回 0 。
     *
     * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
     * */
    public static void main(String[] args) {
        String s = "    ";
        System.out.println(lengthOfLastWord(s));
    }

    /**
     * 从后向前遍历, 干掉所有结尾的空格
     * 处理后的就是字母结尾了
     * 从后向前遍历, 遇到空格就计算从空格到最后的长度
     * */
    private static int lengthOfLastWord(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                s = s.substring(0, i);
            } else {
                break;
            }
        }
        int index = s.length() - 1;
        for (int i = index; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return index - i;
            }
        }
        return s.length();
    }
}

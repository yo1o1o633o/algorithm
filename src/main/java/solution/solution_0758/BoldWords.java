package solution.solution_0758;

/**
 * @author shuai.yang
 */
public class BoldWords {
    /**
     * 给定一个关键词集合 words 和一个字符串 S，将所有 S 中出现的关键词加粗。所有在标签 <b> 和 </b> 中的字母都会加粗。
     *
     * 返回的字符串需要使用尽可能少的标签，当然标签应形成有效的组合。
     *
     * 例如，给定 words = ["ab", "bc"] 和 S = "aabcd"，需要返回 "a<b>abc</b>d"。注意返回 "a<b>a<b>b</b>c</b>d" 会使用更多的标签，因此是错误的。
     * */
    public static void main(String[] args) {
        String[] words = {"e","cab","de","cc","db"};
        String s = "cbccceeead";
        System.out.println(boldWords(words, s));
    }

    /**
     * 先循环找到所有要标记成加粗的索引位
     * 再循环根据加粗索引位对原字符串进行处理
     * */
    private static String boldWords(String[] words, String s) {
        int[] n = new int[s.length()];
        for (String word : words) {
            int l = 0;
            int index = 0;
            while (index > -1) {
                index = s.indexOf(word, l);
                if (index == -1) {
                    continue;
                }
                for (int j = index; j < word.length() + index; j++) {
                    n[j] = 1;
                }
                l = index + 1;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n.length; i++) {
            if (n[i] == 1) {
                if (i == 0) {
                    res.append("<b>");
                }
                if (i != 0 && n[i - 1] == 0) {
                    res.append("<b>");
                }
            }
            res.append(s.charAt(i));
            if (n[i] == 1) {
                if (i == n.length - 1) {
                    res.append("</b>");
                }
                if (i != n.length - 1 && n[i + 1] == 0) {
                    res.append("</b>");
                }
            }
        }
        return res.toString();
    }
}

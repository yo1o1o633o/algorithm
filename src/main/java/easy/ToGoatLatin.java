package easy;

/**
 * @author Yang
 */
public class ToGoatLatin {
    /**
     * 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
     *
     * 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
     *
     * 山羊拉丁文的规则如下：
     *
     * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
     * 例如，单词"apple"变为"applema"。
     *
     * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
     * 例如，单词"goat"变为"oatgma"。
     *
     * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
     * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
     * 返回将 S 转换为山羊拉丁文后的句子。
     * */
    public static void main(String[] args) {
        String s = "I speak Goat Latin";
        System.out.println(toGoatLatin(s));
    }

    /**
     * 根据规则判断, 然后拼接字符串即可
     * */
    private static String toGoatLatin(String s) {
        StringBuilder res = new StringBuilder();
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            if (str[i].charAt(0) == 'a' || str[i].charAt(0) == 'e' || str[i].charAt(0) == 'i' || str[i].charAt(0) == 'o' || str[i].charAt(0) == 'u' || str[i].charAt(0) == 'A' || str[i].charAt(0) == 'E' || str[i].charAt(0) == 'I' || str[i].charAt(0) == 'O' || str[i].charAt(0) == 'U') {
                res.append(str[i]).append("ma");
            } else {
                char c = str[i].charAt(0);
                res.append(str[i].substring(1)).append(c).append("ma");
            }
            for (int j = 0; j <= i; j++) {
                res.append("a");
            }
            res.append(" ");
        }
        return res.toString().substring(0, res.length() - 1);
    }
}

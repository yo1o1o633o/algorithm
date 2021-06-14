package offer.offer_005;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * */
public class Solution {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    private static String replaceSpaceWithFor(String s) {
        StringBuilder r = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                r.append("%20");
            } else {
                r.append(c);
            }
        }
        return r.toString();
    }

    private static String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }
}

package solution.solution_0686;

public class RepeatedStringMatch {
    /**
     * 给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
     *
     * 举个例子，A = "abcd"，B = "cdabcdab"。
     *
     * 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
     * */
    public static void main(String[] args) {
        String A = "abcd";
        String B = "abcdabcdabcd";
        System.out.println(repeatedStringMatch(A, B));
    }

    /**
     * 重复叠加A。 循环判断B是否是叠加后字符串的子串
     * 长度超过两个字符串的总长度， 而且没发现子串，那么表示不存在
     * */
    private static int repeatedStringMatch(String A, String B) {
        int i = 1;
        StringBuilder temp = new StringBuilder(A);
        while (i < 10001) {
            if (temp.toString().contains(B)) {
                return i;
            }
            if (B.length() + A.length() < temp.length()) {
                return -1;
            }
            i++;
            temp.append(A);
        }
        return -1;
    }
}

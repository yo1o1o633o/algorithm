package solution;

/**
 * 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseStringWithWhile(s);
        System.out.println(s);
    }

    /**
     * 双指针。两两交换
     * */
    private static void reverseStringWithWhile(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    /**
     * 双指针。两两交换
     * 节省空间
     * */
    private static void reverseStringWithFor(char[] s) {
        int n = s.length - 1;
        for (int i = 0, j = n; i < j; i++, j--) {
            if (s[i] == s[j]) {
                continue;
            }
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}

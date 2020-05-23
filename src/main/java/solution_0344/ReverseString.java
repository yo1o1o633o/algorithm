package solution_0344;

/**
 * @author Yang
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'a', 'c', 'd', 'e'};
        reverseString(s);
    }

    /**
     * 双指针方式, 两侧向中间交换.
     * 注意循环要到中间位置跳出. 这里i<s.length出现了问题, 循环到一半的时候已经是正确的了, 然后多循环了一遍又换回到原数组序列了
     * */
    private static void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        System.out.println(s);
    }
}

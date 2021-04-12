package archive.solution_old.solution_0345;


/**
 * @author Yang
 */
public class ReverseVowels {
    /**
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     * */
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseVowels(s));;
    }

    /**
     * 双指针法, 在双指针运行过程中增加判断是否是元音字母.
     * */
    private static String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int i = 0;
        int j = cs.length - 1;
        while (i < j) {
            if (cs[i] == 'a' || cs[i] == 'e' || cs[i] == 'i' || cs[i] == 'o' || cs[i] == 'u' || cs[i] == 'A' || cs[i] == 'E' || cs[i] == 'I' || cs[i] == 'O' || cs[i] == 'U') {
                if (cs[j] == 'a' || cs[j] == 'e' || cs[j] == 'i' || cs[j] == 'o' || cs[j] == 'u' || cs[j] == 'A' || cs[j] == 'E' || cs[j] == 'I' || cs[j] == 'O' || cs[j] == 'U') {
                    char temp = cs[i];
                    cs[i] = cs[j];
                    cs[j] = temp;
                    i++;
                    j--;
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }
        return new String(cs);
    }
}

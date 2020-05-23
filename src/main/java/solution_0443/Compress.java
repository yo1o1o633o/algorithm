package solution_0443;

/**
 * @author shuai.yang
 */

public class Compress {
    /**
     * 给定一组字符，使用原地算法将其压缩。
     *
     * 压缩后的长度必须始终小于或等于原数组长度。
     *
     * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
     *
     * 在完成原地修改输入数组后，返回数组的新长度。
     * */
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','b','b','b','b','b','b','b','b','b','b','d'};
        System.out.println(compress(chars));
    }

    /**
     * 双指针
     * 两个标记值, 一个读 一个写
     * */
    private static int compress(char[] chars) {
        int write = 0;
        int anchor = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c : ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        System.out.println(chars);
        return write;
    }
}

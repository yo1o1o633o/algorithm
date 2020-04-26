package easy;

/**
 * @author shuai.yang
 */

public class Compress {
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

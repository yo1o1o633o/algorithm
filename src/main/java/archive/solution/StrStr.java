package archive.solution;

/**
 * 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * @author shuai.yang
 */
public class StrStr {
    public static void main(String[] args) {
        String haystack = "a", needle = "a";
        System.out.println(strStrWithFunction(haystack, needle));
        System.out.println(strStrWithIndexOf(haystack, needle));
    }

    /**
     * 系统函数
     * */
    private static int strStrWithFunction(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * indexOf模拟系统函数处理方式
     * */
    private static int strStrWithIndexOf(String haystack, String needle) {
        int length = needle.length();
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        if (h.length == 0) {
            return n.length == 0 ? h.length : -1;
        }
        if (n.length == 0) {
            return 0;
        }

        char first = n[0];
        int max = h.length - n.length;
        for (int i = 0; i <= max; i++) {
            if (h[i] != first) {
                // 寻找第一个字符在原字符串的位置
                while (++i <= max && h[i] != first) {
                    continue;
                }
            }
            // i就是第一个字符出现的位置
            if (i <= max) {
                int j = i + 1;
                int end = j + length - 1;
                // 依次对比后续字符串.如果一直到被匹配字符串结束都相同.则返回索引
                for (int k = 1; j < end && h[j] == n[k]; j++, k++) {
                    continue;
                }
                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 滑动窗口
     * 线性执行, 每次截取被匹配字符串长度的字符串进行比较
     * haystack.length() - length + 1 避免被匹配字符串比原字符串长的情况
     * */
    private static int strStrWithWindow(String haystack, String needle) {
        int length = needle.length();
        for (int i = 0; i < haystack.length() - length + 1; i++) {
            if (haystack.substring(i, i + length).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}

package solution;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * @author shuai.yang
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] str = {"aaa","aa","aaa","aaa","aaa"};
        System.out.println(longestCommonPrefixWithBinarySearch(str));
    }

    /**
     * 循环比对
     * 取出第一个元素. 分别和其他元素进行比较.
     * */
    private static String longestCommonPrefixWithHead(String[] str) {
        if (str.length == 0) {
            return "";
        }
        if (str.length == 1) {
            return str[0];
        }
        String head = str[0];
        String prefix = "";
        for (int i = 1; i <= head.length(); i++) {
            // 前缀
            prefix = head.substring(0, i);
            for (int j = 1; j < str.length; j++) {
                // 不等于0代表当前字符串中, 前缀不是其实位或者没找到
                if (str[j].indexOf(prefix) != 0) {
                    return head.substring(0, i - 1);
                }
            }
        }
        return prefix;
    }

    /**
     * 使用分治法, 两两进行处理, 找到每两个的公共前缀. 用前缀再进行比较
     * */
    private static String longestCommonPrefixWithDivideAndConquer(String[] str) {
        if (str.length == 0) {
            return "";
        }
        if (str.length == 1) {
            return str[0];
        }
        if (str.length == 2) {
            return divideSearch(str[0], str[1]);
        }
        return divide(str, 0, str.length - 1);
    }
    private static String divide(String[] str, int l, int r) {
        if (r - l < 2) {
            return divideSearch(str[l], str[r]);
        }
        int mid = (l + r) / 2;
        String lt = divide(str, l, mid);
        String rt = divide(str, mid + 1, r);
        return divideSearch(lt, rt);
    }
    /**
     * 求两个字符串的公共前缀
     * */
    private static String divideSearch(String left, String right) {
        int length = Math.min(left.length(), right.length());
        int n = 0;
        while (n < length && left.charAt(n) == right.charAt(n)) {
            n++;
        }
        return left.substring(0, n);
    }

    /**
     * 横向比较. 两两取出公共前缀, 用公共前缀继续和下一个比较
     * */
    private static String longestCommonPrefixWithHorizontal(String[] str) {
        if (str.length == 0) {
            return "";
        }
        if (str.length == 1) {
            return str[0];
        }
        String prefix = str[0];
        for (int i = 1; i < str.length; i++) {
            prefix = divideSearch(prefix, str[i]);
        }
        return prefix;
    }

    /**
     * 二分法. 对字符串进行二分, 如果不是公共前缀, 继续二分.
     * 如果左边满足条件,那么比较右侧. 如果左侧不满足则二分后处理
     * */
    private static String longestCommonPrefixWithBinarySearch(String[] str) {
        if (str.length == 0) {
            return "";
        }
        int min = Integer.MAX_VALUE;
        for (String s : str) {
            min = Math.min(min, s.length());
        }
        int l = 0;
        while (l < min) {
            int mid = (l + min + 1) / 2;
            if (isCommonPrefix(str, mid)) {
                l = mid;
            } else {
                min = mid - 1;
            }
        }
        return str[0].substring(0, min);
    }
    private static boolean isCommonPrefix(String[] str, int length) {
        String first = str[0].substring(0, length);
        for (int i = 1; i < str.length; i++) {
            String tmp = str[i];
            for (int j = 0; j < first.length(); j++) {
                if (tmp.charAt(j) != first.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}


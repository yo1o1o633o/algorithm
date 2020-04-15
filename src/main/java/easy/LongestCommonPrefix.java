package easy;

import java.util.StringJoiner;

/**
 * @author Yang
 */
public class LongestCommonPrefix {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""
     * */
    public static void main(String[] args) {
        String[] str = new String[] {"flower","flow","flight"};
        String res = longestCommonPrefix(str);
        String res2 = longestCommonPrefix2(str);
        String res3 = longestCommonPrefix3(str);
        String res4 = longestCommonPrefix4(str);
        String res5 = longestCommonPrefix5(str);
        System.out.println(res);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        System.out.println(res5);
    }

    /**
     * 循环字符串数组, 依次取每个字符串的索引位字符串比对.
     * */
    private static String longestCommonPrefix(String[] str) {
        if (str == null || str.length <= 0) {
            return "";
        }
        int length = 1000;
        for (String s : str) {
            if (s.length() < length) {
                length = s.length();
            }
        }
        StringBuilder resStr = new StringBuilder();
        boolean returnAll = false;
        for (int i = 0; i < length; i++) {
            String res = String.valueOf(str[0].charAt(i));
            String temp = "";
            for (String s : str) {
                if (!String.valueOf(s.charAt(i)).equals(res)) {
                    returnAll = true;
                    break;
                } else {
                    temp = String.valueOf(s.charAt(i));
                }
            }
            if (returnAll) {
                break;
            }
            resStr.append(temp);
        }
        return resStr.toString();
    }

    /**
     * 循环字符串数组, 依次取每个字符串的索引位字符串比对. 代码优化
     * 不需要依次赋值对比, 直接根据循环判断满足条件的字符索引位, 进行截取
     * 直接用char来记录单个字符. 不要转字符串浪费
     * */
    private static String longestCommonPrefix2(String[] str) {
        if (str == null || str.length <= 0) {
            return "";
        }
        // 以第一个字符串长度循环
        for (int i = 0; i < str[0].length(); i++) {
            char r = str[0].charAt(i);
            for (int j = 1; j < str.length; j++) {
                if (i == str[j].length() || str[j].charAt(i) != r) {
                    return str[0].substring(0, i);
                }
            }
        }
        return str[0];
    }

    /**
     * 两两比较. 取出公共前缀后, 用这个前缀再和下一个比较
     * 水平扫描法
     * LCP(S1…Sn)=LCP(LCP(LCP(S1,S2),S3),…Sn)
     * */
    private static String longestCommonPrefix3(String[] str) {
        if (str == null || str.length <= 0) {
            return "";
        }
        // 第一个元素
        String perStr = str[0];
        // 从第二个元素开始循环
        for (int i = 1; i < str.length; i++) {
            // 用字符串在目标字符串中查找
            while (str[i].indexOf(perStr) != 0) {
                // 没有找到就一直切割掉最后一个, 如果有公共前缀, 那么循环条件就会不满足, 跳出while. 对比下一个元素
                perStr = perStr.substring(0, perStr.length() - 1);
                if (perStr.isEmpty()) {
                    return "";
                }
            }
        }
        return perStr;
    }


    /**
     * 分治法
     * 拆分数组为两组, 分别取两组的公共前缀. 同时处理
     * */
    private static String longestCommonPrefix4(String[] str) {
        if (str == null || str.length <= 0) {
            return "";
        }
        return loopCommonPrefix(str, 0, str.length - 1);
    }
    private static String loopCommonPrefix(String[] str, int l, int r) {
        if (l == r) {
            return str[l];
        } else {
            int mid = (l + r) / 2;
            String leftStr = loopCommonPrefix(str, l, mid);
            String rightStr = loopCommonPrefix(str, mid + 1, r);
            return compared(leftStr, rightStr);
        }
    }
    private static String compared(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }


    /**
     * 二分查找法
     * 找到数组中长度最小的字符串.
     * 二分最小的字符串, 然后和数组中字符串循环比较, 如果前一半都满足, 那么至少前一半是公共的前缀. 比较后一半
     * 如果前一半不满足, 那么继续二分比较
     * */
    private static String longestCommonPrefix5(String[] str) {
        if (str == null || str.length <= 0) {
            return "";
        }
        int min = Integer.MAX_VALUE;
        for (String s : str) {
            if (s.length() < min) {
                min = s.length();
            }
        }
        int low = 1;
        int high = min;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(str, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return str[0].substring(0, (low + high) / 2);
    }
    private static boolean isCommonPrefix(String[] str, int len) {
        String per = str[0].substring(0, len);
        for (int i = 1; i < str.length; i++) {
            if (!str[i].startsWith(per)) {
                return false;
            }
        }
        return true;
    }
}

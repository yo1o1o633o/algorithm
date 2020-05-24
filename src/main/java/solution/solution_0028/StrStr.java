package solution.solution_0028;

/**
 * @author Yang
 */
public class StrStr {
    public static void main(String[] args) {
        String haystack = "aaaaaa";
        String needle = "ab";
        System.out.println(strStr(haystack, needle));
        System.out.println(strStr2(haystack, needle));
    }

    /**
     * 方法一：子串逐一比较 - 线性时间复杂度
     * 取needle长度, 然后以此长度循环分割haystack. 进行循环比较
     * */
    private static int strStr(String haystack, String needle) {
        int length = needle.length();
        if (length == 0) {
            return length;
        }
        int index = 0;
        while (index < (haystack.length() - needle.length() + 1)) {
            String subStr = haystack.substring(index, length + index);
            if (subStr.equals(needle)) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }

    /**
     * 双指针 - 线性时间复杂度
     * 1. 找到以needle第一个字符开始的位置,
     * 2. 向后对比needle个长度
     * 3. 满足即返回, 否则找haystack中第二个以needle第一个字符开始的位置继续.
     * */
    private static int strStr2(String haystack, String needle) {
        int l = needle.length();
        if (l == 0) {
            return l;
        }
        int r = haystack.length();
        int pn = 0;
        while (pn < r - l + 1) {
            // 找到被查找字符串中, needle第一个字符的出现位置
            while (pn < r - l + 1 && haystack.charAt(pn) != needle.charAt(0)) {
                ++pn;
            }
            int pl = 0;
            int cpl = 0;
            while (pl < l && pn < r && haystack.charAt(pn) == needle.charAt(pl)) {
                ++pn;
                ++pl;
                ++cpl;
            }
            if (cpl == l) {
                return pn - cpl;
            }
            pn = pn - cpl + 1;
        }
        return -1;
    }


    /**
     * KMP算法
     * 理解:
     * 1. 主要是处理要查找的字符串, 将其变成一个数组.
     * 2. 这个数组中保存的是索引, 即对应位置不匹配时要移动的索引
     * 3. 主要应用最长公共前缀.
     * */
    private static void kmp(String haystack, String needle) {

    }
}

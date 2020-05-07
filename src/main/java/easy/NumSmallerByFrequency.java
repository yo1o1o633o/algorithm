package easy;

import java.util.Arrays;

public class NumSmallerByFrequency {
    /**
     * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
     *
     * 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
     *
     * 现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
     *
     * 题目的要求。即有这么个方法，这个方法返回一个字符串的最小字母出现的次数
     * 现在传入了一个字符串数组， 还有另一个字符串数组words。 用传入的数组去words去找， 依次找比这个大的个数
     *
     * 示例 2：
     *
     * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
     * 输出：[1,2]
     * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
     *
     * "bbb"的次数是3， 然后words里大于3的字符串只有"aaaa", 所以对应1
     * "cc"的次数是2， words里大于2的有"aaa", "aaaa", 所以是2
     */
    public static void main(String[] args) {
        String[] queries = {"bbb","cc"};
        String[] words = {"a","aa","aaa","aaaa"};
        System.out.println(Arrays.toString(numSmallerByFrequency(queries, words)));
        System.out.println(Arrays.toString(numSmallerByFrequency2(queries, words)));
        System.out.println(Arrays.toString(numSmallerByFrequency3(queries, words)));
        System.out.println(Arrays.toString(numSmallerByFrequency4(queries, words)));
    }

    /**
     * 暴力循环
     * */
    private static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            int queriesNum = getNums(q);
            int num = 0;
            for (String word : words) {
                int wordsNum = getNums(word);
                if (wordsNum > queriesNum) {
                    num++;
                }
            }
            res[i] = num;
        }
        return res;
    }

    /**
     * 暴力循环2 性能提升
     * */
    private static int[] numSmallerByFrequency2(String[] queries, String[] words) {
        int[] queriesNums = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            queriesNums[i] = getNums(queries[i]);
        }
        int[] wordsNums = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordsNums[i] = getNums(words[i]);
        }
        // 排序是关键
        Arrays.sort(wordsNums);
        int[] res = new int[queries.length];
        for (int i = 0; i < queriesNums.length; i++) {
            int num = 0;
            for (int wordsNum : wordsNums) {
                if (wordsNum > queriesNums[i]) {
                    num++;
                }
            }
            res[i] = num;
        }
        return res;
    }

    /**
     * 相对上边， 节约了一次循环。
     * */
    private static int[] numSmallerByFrequency3(String[] queries, String[] words) {
        int[] wordsNums = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordsNums[i] = getNums(words[i]);
        }
        // 排序是关键
        Arrays.sort(wordsNums);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int queriesNum = getNums(queries[i]);
            int num = 0;
            for (int wordsNum : wordsNums) {
                if (wordsNum > queriesNum) {
                    num++;
                }
            }
            res[i] = num;
        }
        return res;
    }

    /**
     * 二分查找
     * */
    private static int[] numSmallerByFrequency4(String[] queries, String[] words) {
        int[] wordsNums = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordsNums[i] = getNums(words[i]);
        }
        // 排序是关键
        Arrays.sort(wordsNums);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int queriesNum = getNums(queries[i]);
            res[i] = binarySearch(queriesNum, wordsNums);
        }
        return res;
    }
    /**
     * 循环个中间值比较， 当中间值比他大时， 那么中间值右边的就不用比较了， 都是比他大的。 继续比较左边的。
     * */
    private static int binarySearch(int queriesNum, int[] wordsNums) {
        int length = wordsNums.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (wordsNums[mid] > queriesNum) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 如果第一个值小于等于queriesNum,因为等于不符合条件,那么返回0个
        if (wordsNums[left] <= queriesNum) {
            return 0;
        }
        return length - left;
    }

    private static int getNums(String s) {
        int[] words = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            words[c - 'a']++;
        }
        for (int w : words) {
            if (w > 0) {
                return w;
            }
        }
        return 0;
    }
}

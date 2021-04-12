package archive.solution_old.solution_0819;

import java.util.*;

public class MostCommonWord {
    /**
     * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
     *
     * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
     *
     * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
     *
     * */
    public static void main(String[] args) {
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};
        System.out.println(mostCommonWord(paragraph, banned));
        System.out.println(mostCommonWord2(paragraph, banned));
        System.out.println(mostCommonWord3(paragraph, banned));
    }

    /**
     * 缺心眼的题啊！ "a, a, a, a, b,b,b,c, c"  b,b,b,c,居然不是一个单词。
     * 把所有的符号替换成空格
     * 再移除多余空格保证每个单词中有一个空格
     * 再对每个单词进行拆分大写转小写。
     * 转成小写的单词后判断是否在禁用单词列表里  不在就放到map里进行统计
     * 最后取map里的最大的那个key
     * */
    private static String mostCommonWord(String paragraph, String[] banned) {
        StringBuilder paragraphNoWord = new StringBuilder();
        for (int i = 0; i < paragraph.length(); i++) {
            if (paragraph.charAt(i) == '!' || paragraph.charAt(i) == '?' || paragraph.charAt(i) == '\'' || paragraph.charAt(i) == ',' || paragraph.charAt(i) == ';' || paragraph.charAt(i) == '.') {
                paragraphNoWord.append(" ");
            } else {
                paragraphNoWord.append(paragraph.charAt(i));
            }
        }
        String[] paragraphs = paragraphNoWord.toString().split(" ");
        List<String> paragraphsRes = new ArrayList<>();
        for (String p : paragraphs) {
            if (!p.equals("")) {
                paragraphsRes.add(p);
            }
        }

        List<String> bannedList = Arrays.asList(banned);
        HashMap<String, Integer> maps = new HashMap<>();
        for (String s : paragraphsRes) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                char w = Character.toLowerCase(s.charAt(j));
                if (w - 'a' >= 0 && w - 'a' < 26) {
                    temp.append(w);
                }
            }
            if (!bannedList.contains(temp.toString())) {
                if (maps.containsKey(temp.toString())) {
                    maps.put(temp.toString(), maps.get(temp.toString()) + 1);
                } else {
                    maps.put(temp.toString(), 1);
                }
            }
        }
        String res = "";
        Integer num = 0;
        for (Map.Entry<String, Integer> map : maps.entrySet()) {
            if (map.getValue() > num) {
                num = map.getValue();
                res = map.getKey();
            }
        }
        return res;
    }

    private static String mostCommonWord2(String paragraph, String[] banned) {
        StringBuilder paragraphNoWord = new StringBuilder();
        for (int i = 0; i < paragraph.length(); i++) {
            if (paragraph.charAt(i) == '!' || paragraph.charAt(i) == '?' || paragraph.charAt(i) == '\'' || paragraph.charAt(i) == ',' || paragraph.charAt(i) == ';' || paragraph.charAt(i) == '.') {
                if (i != paragraph.length() - 1 && paragraph.charAt(i + 1) != ' ') {
                    paragraphNoWord.append(" ");
                }
            } else {
                paragraphNoWord.append(Character.toLowerCase(paragraph.charAt(i)));
            }
        }
        String[] paragraphs = paragraphNoWord.toString().split(" ");

        List<String> bannedList = Arrays.asList(banned);
        HashMap<String, Integer> maps = new HashMap<>();
        for (String s : paragraphs) {
            if (!bannedList.contains(s)) {
                if (maps.containsKey(s)) {
                    maps.put(s, maps.get(s) + 1);
                } else {
                    maps.put(s, 1);
                }
            }
        }
        String res = "";
        Integer num = 0;
        for (Map.Entry<String, Integer> map : maps.entrySet()) {
            if (map.getValue() > num) {
                num = map.getValue();
                res = map.getKey();
            }
        }
        return res;
    }

    /**
     * 一次循环， 转小写判断是否是字母， 是就拼接
     * 不是字母那么就判断是否在禁用单词列表里， 不在继续判断当前map里有比这个key大的没有
     * 如果比他大， 那么更新值
     * */
    private static String mostCommonWord3(String paragraph, String[] banned) {
        paragraph += ".";
        List<String> bannedList = Arrays.asList(banned);
        char[] paragraphs = paragraph.toCharArray();
        HashMap<String, Integer> maps = new HashMap<>();
        StringBuilder temp = new StringBuilder();
        String res = "";
        Integer max = 0;
        for (char par : paragraphs) {
            char w = Character.toLowerCase(par);
            if (w - 'a' >= 0 && w - 'a' < 26) {
                temp.append(w);
            } else {
                String s = temp.toString();
                if (!s.equals("") && !bannedList.contains(s)) {
                    Integer num = maps.getOrDefault(s, 0) + 1;
                    maps.put(s, num);
                    if (num > max) {
                        max = num;
                        res = s;
                    }
                }
                temp = new StringBuilder();
            }
        }
        return res;
    }
}

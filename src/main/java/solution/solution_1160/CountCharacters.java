package solution.solution_1160;

import java.util.HashMap;
import java.util.Map;

public class CountCharacters {
    /**
     * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
     *
     * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
     *
     * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
     *
     * 返回词汇表 words 中你掌握的所有单词的 长度之和。
     * */
    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(countCharacters(words, chars));
        System.out.println(countCharacters1(words, chars));
        System.out.println(countCharacters2(words, chars));
    }

    /**
     * 定义两个Map 一个保存chars的各个字符次数。 一个保存数组中每个字符串的映射
     * */
    private static int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            map.put(chars.charAt(i), map.getOrDefault(chars.charAt(i), 0) + 1);
        }
        int count = 0;
        for (String word : words) {
            Map<Character, Integer> tempMap = new HashMap<>();
            for (int j = 0; j < word.length(); j++) {
                tempMap.put(word.charAt(j), tempMap.getOrDefault(word.charAt(j), 0) + 1);
            }
            boolean f = false;
            for (Map.Entry<Character, Integer> m : tempMap.entrySet()) {
                if (!map.containsKey(m.getKey()) || map.get(m.getKey()) < m.getValue()) {
                    f = true;
                    break;
                }
            }
            if (!f) {
                count += word.length();
            }
        }
        return count;
    }

    /**
     * 用字母表替换HashMap
     * */
    private static int countCharacters1(String[] words, String chars) {
        int[] wordArr = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            wordArr[chars.charAt(i) - 'a']++;
        }
        int count = 0;
        for (String word : words) {
            int[] tempArr = new int[26];
            for (int j = 0; j < word.length(); j++) {
                tempArr[word.charAt(j) - 'a']++;
            }
            boolean f = false;
            for (int i = 0; i < wordArr.length; i++) {
                if (wordArr[i] < tempArr[i]) {
                    f = true;
                    break;
                }
            }
            if (!f) {
                count += word.length();
            }
        }
        return count;
    }

    /**
     * 替换转成Char数组
     * 判断时不使用标记变量， 使用跳转语句块
     * */
    private static int countCharacters2(String[] words, String chars) {
        int[] wordArr = new int[26];
        for (char c : chars.toCharArray()) {
            wordArr[c - 'a']++;
        }
        int count = 0;
        a: for (String word : words) {
            int[] tempArr = new int[26];
            for (char c : word.toCharArray()) {
                tempArr[c - 'a']++;
            }
            for (int i = 0; i < wordArr.length; i++) {
                if (wordArr[i] < tempArr[i]) {
                    continue a;
                }
            }
            count += word.length();
        }
        return count;
    }
}

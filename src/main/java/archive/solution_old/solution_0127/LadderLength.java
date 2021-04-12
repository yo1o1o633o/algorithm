package archive.solution_old.solution_0127;

import javafx.util.Pair;

import java.util.*;

/**
 * @author shuai.yang
 */
public class LadderLength {
    /**
     * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
     *
     * 每次转换只能改变一个字母。
     * 转换过程中的中间单词必须是字典中的单词。
     * 说明:
     *
     * 如果不存在这样的转换序列，返回 0。
     * 所有单词具有相同的长度。
     * 所有单词只由小写字母组成。
     * 字典中不存在重复的单词。
     * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
     * */
    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        String[] words = {"hot","dog"};
        List<String> wordList = Arrays.asList(words);
        System.out.println(ladderLength1(beginWord, endWord, wordList));
    }

    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        set.add(beginWord);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll != null) {
                    if (poll.equals(endWord)) {
                        return step;
                    }
                    for (String word : wordList) {
                        if (set.contains(word)) {
                            continue;
                        }
                        int n = 0;
                        // 每次都要循环判断一圈, 哪些是可以改变1个字母得到的词
                        for (int j = 0; j < word.length(); j++) {
                            if (poll.charAt(j) == word.charAt(j)) {
                                n++;
                            }
                        }
                        if (n == word.length() - 1) {
                            queue.add(word);
                            set.add(word);
                        }
                    }
                }
            }
        }
        return 0;
    }

    private static int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        // 没有结束词直接返回
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // 每个单词长度相同
        int len = beginWord.length();
        // 处理给出的字典单词, 转换为全部的通用状态及每个通配词的映射关系
        Map<String, List<String>> allComboDict = new HashMap<>();
        // lambda表达式, curWord当前循环的单词
        wordList.forEach(curWord -> {
            for (int i = 0; i < len; i++) {
                // 替换指定字符为通配符, 每个单词都能得到len种通配词. 如 log对应: *og, l*g, lo*
                String comboWord = curWord.substring(0, i) + "*" + curWord.substring(i + 1, len);
                // 从映射字典中拿到这个通配词对于的单词列表, 没有就创建一个新的列表
                List<String> comboWordList = allComboDict.getOrDefault(comboWord, new ArrayList<>());
                // 将当前单词加到这个通配词的映射列表中
                comboWordList.add(curWord);
                // 更新这个通配词在字典中的映射关系
                allComboDict.put(comboWord, comboWordList);
            }
        });
        // 开始广度优先遍历
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        // 定义一个Map记录已经遍历过的单词
        HashMap<String, Boolean> hasVisedList = new HashMap<>();
        // 将开始单词加入到队列中
        queue.add(new Pair<>(beginWord, 1));
        // 将开始单词加入到记录Map中
        hasVisedList.put(beginWord, true);
        while (!queue.isEmpty()) {
            // 使用remove, 当获取到null时, 里面有异常抛出. poll需要自己判断null
            Pair<String, Integer> node = queue.remove();
            String curWord = node.getKey();
            int level = node.getValue();
            for (int j = 0; j < len; j++) {
                // 从当前单词, 得到len个通配词
                String comboWord = curWord.substring(0, j) + "*" + curWord.substring(j + 1, len);
                // 拿到当前通配词的映射单词
                List<String> currComboWordList = allComboDict.getOrDefault(comboWord, new ArrayList<>());
                for (String word : currComboWordList) {
                    // 碰到要求的单词, 返回
                    if (word.equals(endWord)) {
                        return level + 1;
                    }
                    // 判断当前单词是否已经遍历过, 没有遍历过放入队列继续
                    if (!hasVisedList.containsKey(word)) {
                        queue.add(new Pair<>(word, level + 1));
                        // 标记已经访问过
                        hasVisedList.put(word, true);
                    }
                }
            }
        }
        return 0;
    }
}

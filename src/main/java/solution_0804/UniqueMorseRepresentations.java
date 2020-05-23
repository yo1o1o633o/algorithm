package solution_0804;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Yang
 */
public class UniqueMorseRepresentations {
    /**
     * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
     *
     * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
     *
     * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
     * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
     * */
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
        System.out.println(uniqueMorseRepresentations2(words));
    }

    /**
     * HashMap
     * */
    private static int uniqueMorseRepresentations(String[] words) {
        String[] s = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            StringBuilder w = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                w.append(s[word.charAt(j) - 'a']);
            }
            if (map.containsKey(w.toString())) {
                map.put(w.toString(), map.get(w.toString()) + 1);
            } else {
                map.put(w.toString(), 1);
            }
        }
        return map.size();
    }

    /**
     * 利用HashSet的不能有同一个元素的特性.
     * */
    private static int uniqueMorseRepresentations2(String[] words) {
        String[] s = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder w = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                w.append(s[word.charAt(j) - 'a']);
            }
            set.add(w.toString());
        }
        return set.size();
    }
}

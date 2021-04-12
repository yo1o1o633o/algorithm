package archive.solution_old.solution_0383;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yang
 */
public class CanConstruct {
    /**
     * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
     *
     * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
     * */
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
        System.out.println(canConstruct2(ransomNote, magazine));
    }

    /**
     * 提取两个字符串中的字符, 转成HashMap.同一个字符进行累加
     * 如果第一个字符串中有出现多次的字符 如aa. 那么另一个字符串中一定有a > 2的hash值
     * */
    private static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ranMaps = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            if (ranMaps.containsKey(ransomNote.charAt(i))) {
                ranMaps.put(ransomNote.charAt(i), ranMaps.get(ransomNote.charAt(i)) + 1);
            } else {
                ranMaps.put(ransomNote.charAt(i), 1);
            }
        }
        HashMap<Character, Integer> zinMaps = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            if (zinMaps.containsKey(magazine.charAt(i))) {
                zinMaps.put(magazine.charAt(i), zinMaps.get(magazine.charAt(i)) + 1);
            } else {
                zinMaps.put(magazine.charAt(i), 1);
            }
        }
        for (Map.Entry<Character, Integer> ran : ranMaps.entrySet()) {
            if (zinMaps.get(ran.getKey()) == null) {
                return false;
            }
            if (zinMaps.get(ran.getKey()) < ran.getValue()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 类似于Hash表. 区别是用数组来记录. 数组的索引下标和字符排序对应. 通过对应索引位的值来判断
     * */
    private static boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        // 预留26个元素, 保存26个小写字母的对应值
        int[] caps = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int index = magazine.indexOf(c, caps[c - 'a']);
            if (index == -1) {
                return false;
            }
            // 97 - n, 即数组的索引0对应字符a.1对应b...
            caps[c - 97] = index + 1;
        }
        return true;
    }
}

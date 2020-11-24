package solution_old.solution_0500;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shuai.yang
 */
public class FindWords {
    /**
     * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词
     * */
    public static void main(String[] args) {
        String[] s = {"adsdf","sfd"};
        System.out.println(Arrays.toString(findWords(s)));
        System.out.println(Arrays.toString(findWords1(s)));
    }

    /**
     * 利用字符在字符串中的位置进行查询比对
     * */
    private static String[] findWords(String[] words) {
        String[] ws = {"qwertyuiopQWERTYUIOP", "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM"};
        int count = 0;
        String[] res = new String[words.length];
        for (String s : words) {
            String temp = "";
            if (ws[0].indexOf(s.charAt(0)) != -1) {
                temp = ws[0];
            } else if (ws[1].indexOf(s.charAt(0)) != -1) {
                temp = ws[1];
            } else if (ws[2].indexOf(s.charAt(0)) != -1) {
                temp = ws[2];
            }
            boolean f = false;
            for (int i = 0; i < s.length(); i++) {
                if (temp.indexOf(s.charAt(i)) == -1) {
                    f = true;
                    break;
                }
            }
            if (f) {
                continue;
            }
            res[count] = s;
            count++;
        }
        return Arrays.copyOf(res, count);
    }


    /**
     * 列出所有可能的字母. 拼成3个set集合. 表示3行键盘位. 依次对比每个字符串
     * */
    private static String[] findWords1(String[] words) {
        Set<Character> set1 = new HashSet<>();
        set1.add('q');
        set1.add('w');
        set1.add('e');
        set1.add('r');
        set1.add('t');
        set1.add('y');
        set1.add('u');
        set1.add('i');
        set1.add('o');
        set1.add('p');
        set1.add('Q');
        set1.add('W');
        set1.add('E');
        set1.add('R');
        set1.add('T');
        set1.add('Y');
        set1.add('U');
        set1.add('I');
        set1.add('O');
        set1.add('P');
        Set<Character> set2 = new HashSet<>();
        set2.add('a');
        set2.add('s');
        set2.add('d');
        set2.add('f');
        set2.add('g');
        set2.add('h');
        set2.add('j');
        set2.add('k');
        set2.add('l');
        set2.add('A');
        set2.add('S');
        set2.add('D');
        set2.add('F');
        set2.add('G');
        set2.add('H');
        set2.add('J');
        set2.add('K');
        set2.add('L');
        Set<Character> set3 = new HashSet<>();
        set3.add('z');
        set3.add('x');
        set3.add('c');
        set3.add('v');
        set3.add('b');
        set3.add('n');
        set3.add('m');
        set3.add('Z');
        set3.add('X');
        set3.add('C');
        set3.add('V');
        set3.add('B');
        set3.add('N');
        set3.add('M');
        String[] res = new String[words.length];
        int count = 0;
        for (String s : words) {
            Set<Character> set = null;
            if (set1.contains(s.charAt(0))) {
                set = set1;
            }
            if (set2.contains(s.charAt(0))) {
                set = set2;
            }
            if (set3.contains(s.charAt(0))) {
                set = set3;
            }
            if (set == null) {
                continue;
            }
            boolean f = false;
            for (int i = 0; i < s.length(); i++) {
                if (!set.contains(s.charAt(i))) {
                    f = true;
                    break;
                }
            }
            if (f) {
                continue;
            }
            res[count] = s;
            count++;
        }
        return Arrays.copyOf(res, count);
    }
}

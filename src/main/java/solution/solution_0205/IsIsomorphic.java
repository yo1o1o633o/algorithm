package solution.solution_0205;

import java.util.HashMap;

/**
 * @author shuai.yang
 */
public class IsIsomorphic {
    /**
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     *
     * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
     *
     * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
     * */
    public static void main(String[] args) {
        String s = "eggc";
        String t = "addd";
        System.out.println(isIsomorphic(s, t));
        System.out.println(isIsomorphic1(s, t));
        System.out.println(isIsomorphic2(s, t));
        System.out.println(isIsomorphic3(s, t));
    }

    /**
     * 两次Hash表
     * */
    private static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (mapS.containsKey(s.charAt(i)) && mapS.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
            if (mapT.containsKey(t.charAt(i)) && mapT.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
            mapS.put(s.charAt(i), t.charAt(i));
            mapT.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }

    /**
     * 一个hash表
     * */
    private static boolean isIsomorphic1(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }
    private static boolean isIsomorphicHelper(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
            map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }

    /**
     * 根据字符索引位判断. 相同的映射所处的索引位一定是相同的.
     * */
    private static boolean isIsomorphic2(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    /**
     * 用数组替换hash表
     * */
    private static boolean isIsomorphic3(String s, String t) {
        return isIsomorphicHelper1(s, t) && isIsomorphicHelper1(t, s);
    }
    private static boolean isIsomorphicHelper1(String s, String t) {
        int[] maps = new int[128];
        for (int i = 0; i < s.length(); i++) {
            if (maps[s.charAt(i)] == 0) {
                maps[s.charAt(i)] = t.charAt(i);
            } else {
                if (maps[s.charAt(i)] != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}

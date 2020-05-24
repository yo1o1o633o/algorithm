package solution.solution_0925;


import java.util.ArrayList;
import java.util.List;

public class IsLongPressedName {
    /**
     * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
     *
     * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
     * */
    public static void main(String[] args) {
        String name = "alex";
        String typed = "alexxr";
        System.out.println(isLongPressedName(name, typed));
        System.out.println(isLongPressedName2(name, typed));
    }

    /**
     * 按块分组。 将相同的字符当成一块同时记录个数
     * 最后循环比较两个记录个数。 如果有1个小于情况。 则不成立
     * */
    private static boolean isLongPressedName(String name, String typed) {
        Group nameGroup = grouping(name);
        Group typedGroup = grouping(typed);
        if (!nameGroup.key.equals(typedGroup.key)) {
            return false;
        }
        for (int i = 0; i < nameGroup.count.size(); i++) {
            if (nameGroup.count.get(i) > typedGroup.count.get(i)) {
                return false;
            }
        }
        return true;
    }
    private static Group grouping(String s) {
        StringBuilder key = new StringBuilder();
        List<Integer> count = new ArrayList<>();
        int anchor = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                key.append(s.charAt(i));
                count.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return new Group(key.toString(), count);
    }
    public static class Group {
        String key;
        List<Integer> count;
        public Group(String k, List<Integer> c) {
            key = k;
            count = c;
        }
    }

    /**
     * 双指针。 循环比对~
     * */
    private static boolean isLongPressedName2(String name, String typed) {
        char[] n = name.toCharArray();
        char[] t = typed.toCharArray();
        int nl = n.length;
        int tl = t.length;
        if (tl < nl || tl == 0 || nl == 0) {
            return false;
        }
        if (nl == tl) {
            return true;
        }
        int i = 0;
        int j = 0;
        while (i < nl && j < tl) {
            if (n[i] == t[j]) {
                i++;
                j++;
            } else {
                i++;
            }
            if (i == nl) {
                return true;
            }
        }
        return false;
    }
}

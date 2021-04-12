package archive.solution_old.solution_0844;

import java.util.Stack;

/**
 * @author shuai.yang
 */
public class BackspaceCompare {
    /**
     * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
     *
     * 注意：如果对空文本输入退格字符，文本继续为空。
     * */
    public static void main(String[] args) {
        String S = "y#fo##f";
        String T = "y#f#o##f";
        System.out.println(backspaceCompare(S, T));
    }

    private static boolean backspaceCompare(String S, String T) {
        char[] cs = S.toCharArray();
        char[] ct = T.toCharArray();
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        for (char c : cs) {
            if (!sStack.isEmpty() && c == '#') {
                sStack.pop();
                continue;
            }
            if (c != '#') {
                sStack.push(c);
            }
        }
        for (char c : ct) {
            if (!tStack.isEmpty() && c == '#') {
                tStack.pop();
                continue;
            }
            if (c != '#') {
                tStack.push(c);
            }
        }
        if (tStack.size() != sStack.size()) {
            return false;
        }
        while (!sStack.isEmpty()) {
            if (!sStack.pop().equals(tStack.pop())) {
                return false;
            }
        }
        return true;
    }
}

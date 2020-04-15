package easy;

/**
 * @author Yang
 */
public class ValidParenthesis {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * () {} [] (()) {{}}  {[]}  {{[[()]]}}  {{[({})]}}{}
     * */
    public static void main(String[] args) {
        String s = "()[]{}[";
        System.out.println(isValid(s));
    }

    /**
     * 思路 , 必然是偶数个 , 不然就是不满足的
     * */
    private static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        return true;
    }
}

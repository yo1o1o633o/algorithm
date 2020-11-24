package solution_old.solution_0293;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuai.yang
 */
public class GeneratePossibleNextMoves {
    /**
     * 你和朋友玩一个叫做「翻转游戏」的游戏，游戏规则：给定一个只有 + 和 - 的字符串。你和朋友轮流将 连续 的两个 "++" 反转成 "--"。 当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。
     *
     * 请你写出一个函数，来计算出第一次翻转后，字符串所有的可能状态。
     * */
    public static void main(String[] args) {
        String s = "++++";
        System.out.println(generatePossibleNextMoves(s));
        System.out.println(generatePossibleNextMoves1(s));
    }

    /**
     * 线性处理. 碰到两个连续的+ 就把+替换成-- 并放入列表中
     * */
    private static List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                res.add(s.substring(0, i) + "--" + s.substring(i + 2));
            }
        }
        return res;
    }

    /**
     * 字符串切割替换成StringBuilder对字符位操作. 性能快
     * */
    private static List<String> generatePossibleNextMoves1(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                StringBuilder t = new StringBuilder(s);
                t.setCharAt(i, '-');
                t.setCharAt(i + 1, '-');
                String str = t.toString();
                res.add(str);
            }
        }
        return res;
    }
}

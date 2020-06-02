package solution.solution_0246;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuai.yang
 */
public class IsCenterSymmetry {
    /**
     * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
     *
     * 请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。
     * */
    public static void main(String[] args) {
        String num = "69";
        System.out.println(isCenterSymmetry(num));
        System.out.println(isCenterSymmetry1(num));
        System.out.println(isCenterSymmetry2(num));
    }

    /**
     * 定义hash表. 只有以下几种可以翻转
     * 如果遇到不是hash里的数字. 那么就返回false
     * */
    private static boolean isCenterSymmetry(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('1', '1');
        map.put('0', '0');
        String res = "";
        for (int i = 0; i < num.length(); i++) {
            if (map.containsKey(num.charAt(i))) {
                res = map.get(num.charAt(i)) + res;
            } else {
                return false;
            }
        }
        return res.equals(num);
    }

    /**
     * 双指针.前后判断. 碰到018就判断相等. 碰到69就替换之后判断相等. 碰到23457就返回false
     * */
    private static boolean isCenterSymmetry1(String num) {
        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            if (num.charAt(i) == '0' || num.charAt(i) == '1' || num.charAt(i) == '8') {
                if (num.charAt(i) != num.charAt(j)) {
                    return false;
                }
            } else if (num.charAt(i) == '6') {
                char k = '9';
                if (k != num.charAt(j)) {
                    return false;
                }
            } else if (num.charAt(i) == '9') {
                char k = '6';
                if (k != num.charAt(j)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 换成case判断
     * */
    private static boolean isCenterSymmetry2(String num) {
        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            char k = num.charAt(i);
            switch (num.charAt(i)) {
                case '0':
                case '1':
                case '8':
                    break;
                case '6':
                    k = '9';
                    break;
                case '9':
                    k = '6';
                    break;
                default:
                    return false;
            }
            if (k != num.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}

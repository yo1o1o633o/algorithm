package solution_0013;

import java.util.HashMap;

/**
 * @author Yang
 */
public class RomanNumeralToInteger {
    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     * */
    public static void main(String[] args) {
        Integer res = romanToInt("D");
        Integer res2 = romanToInt2("D");
        Integer res3 = romanToInt3("D");
        System.out.println(res);
        System.out.println(res2);
        System.out.println(res3);
    }

    /**
     * 循环进行前后比较, 右边比左边字符大则触发特殊处理
     * */
    private static int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        String[] str = s.split("");
        if (str.length == 1) {
            return map.get(s);
        }
        int num = 0;
        for (int i = 0; i < str.length - 1; i++) {
            // 左边大于等于右边
            if (map.get(str[i]) >= map.get(str[i + 1])) {
                num += map.get(str[i]);
            } else {
                num += map.get(str[i + 1]) - map.get(str[i]);
                i++;
            }
            if (i == str.length - 2) {
                num += map.get(str[i + 1]);
            }
        }
        return num;
    }

    /**
     * 修改上边的写法, hashmap改为whitch
     * */
    private static int romanToInt2(String s) {
        String[] str = s.split("");
        if (str.length == 1) {
            return getNum(s);
        }
        int num = 0;
        for (int i = 0; i < str.length - 1; i++) {
            // 左边大于等于右边
            if (getNum(str[i]) >= getNum(str[i + 1])) {
                num += getNum(str[i]);
            } else {
                num += getNum(str[i + 1]) - getNum(str[i]);
                i++;
            }
            if (i == str.length - 2) {
                num += getNum(str[i + 1]);
            }
        }
        return num;
    }

    /**
     * 字符串可以直接取char进行操作, 省略分割字符串操作
     * 循环判断, 当后一个小于前一个, 那么做减法运算 否则相加. 然后处理最后一个字符
     * switch入参可以用char 可以省略char转String的操作
     * */
    private static int romanToInt3(String s) {
        int sum = 0;
        int perNum = getNum(String.valueOf(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            int num = getNum(String.valueOf(s.charAt(i)));
            if (perNum < num) {
                sum -= perNum;
            } else {
                sum += perNum;
            }
            perNum = num;
        }
        sum += perNum;
        return sum;
    }


    private static int getNum(String s) {
        switch (s) {
            case "I":
                return 1;
            case "V":
                return 5;
            case "X":
                return 10;
            case "L":
                return 50;
            case "C":
                return 100;
            case "D":
                return 500;
            case "M":
                return 1000;
            default:
                return 0;
        }
    }
}

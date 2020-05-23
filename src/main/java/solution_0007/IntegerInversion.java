package solution_0007;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yang
 */
public class IntegerInversion {
    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * */
    public static void main(String[] args) {
        int res = run(-2147483648);
        int secondRes = secondRun(123);
        int thirdRes = thirdRun(1534236469);
        int fourthRes = fourthRun(-2147483412);
        System.out.println(res);
        System.out.println(secondRes);
        System.out.println(thirdRes);
        System.out.println(fourthRes);
    }

    /**
     * 最笨办法, 反向取值拼接然后转数据类型, 超出限制做判断
     * */
    private static int run(int num) {
        if (num == 0) {
            return 0;
        }
        boolean flag = false;
        String[] numArr = Integer.toString(num).split("");
        int count = numArr.length;

        int start = 0;
        if ("-".equals(numArr[0])) {
            flag = true;
            start = 1;
        }
        String[] resArr = new String[count - start];
        for (int i = start; i <= count - 1; i++) {
            resArr[count - 1 - i] = numArr[i];
        }
        StringBuilder str = new StringBuilder();
        for (String res : resArr) {
            str.append(res);
        }
        long resNum = Long.parseLong(str.toString());
        if (flag) {
            resNum = resNum * -1;
        }
        if (resNum <= Integer.MAX_VALUE && resNum >= Integer.MIN_VALUE) {
            return (int) resNum;
        }
        return 0;
    }

    /**
     * 使用双向链表, 并没有解决问题
     * */
    private static int secondRun(int num) {
        LinkedList<String> list = new LinkedList<>();
        String[] numArr = Integer.toString(num).split("");
        for (int i = 0; i <= numArr.length - 1; i++) {
            list.addFirst(numArr[i]);
        }
        boolean flag = false;
        if ("-".equals(list.getLast())) {
            flag = true;
        }
        StringBuilder str = new StringBuilder();
        while (true) {
            if (list.size() > 0) {
                String s = list.removeFirst();
                if (!"-".equals(s)) {
                    str.append(s);
                }
            } else {
                break;
            }
        }
        long resNum = Long.parseLong(str.toString());
        if (flag) {
            resNum = resNum * -1;
        }
        if (resNum <= Integer.MAX_VALUE && resNum >= Integer.MIN_VALUE) {
            return (int) resNum;
        }
        return 0;
    }

    /**
     * 数学算法, 每次进行取模运算, 得到最后一个数字
     * 然后进行组装
     * */
    private static int thirdRun(int num) {
        int res = 0;
        while (num != 0) {
            int rev = num % 10;
            num /= 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && rev > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && rev < -8)) {
                return 0;
            }
            res = res * 10 + rev;
        }
        return res;
    }

    private static int fourthRun(int num) {
        if (num == 0) {
            return 0;
        }
        boolean flag = num < 0;
        long longNum = flag ? num * -1 : num;
        List<Long> numList = new ArrayList<>();
        while (longNum != 0) {
            numList.add(longNum % 10);
            longNum /= 10;
        }
        int res = Math.toIntExact(numList.get(0));
        for (int i = 1; i < numList.size(); i++) {
            if (res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            res *= 10;
            if (res > Integer.MAX_VALUE - Math.toIntExact(numList.get(i))) {
                return 0;
            }
            res += Math.toIntExact(numList.get(i));
        }
        res = flag ? -1 * res : res;
        return res;
    }
}

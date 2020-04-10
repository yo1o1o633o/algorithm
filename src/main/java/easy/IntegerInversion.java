package easy;

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
//        int res = run(-2147483648);
//        int secondRes = secondRun(123);
        int thirdRes = thirdRun(1534236469);
//        System.out.println(res);
//        System.out.println(secondRes);
        System.out.println(thirdRes);
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

    private static int thirdRun(int num) {
        int rev = 0;
        int res = 0;
        while (true) {
            rev = num % 10;
            res = res * 10 + rev;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
            num /= 10;
            if (num == 0) {
                break;
            }
        }
        return res;
    }
}

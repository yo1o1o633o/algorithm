package archive.solution_old.solution_0202;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shuai.yang
 */
public class IsHappy {
    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     *
     * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
     *
     * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
     * */
    public static void main(String[] args) {
        int num = 19;
        System.out.println(isHappy(num));
        System.out.println(isHappy1(num));
        System.out.println(isHappy2(num));
        System.out.println(isHappy3(num));
    }

    /**
     * 循环
     * 当循环中发现是一个快乐数是 返回true
     * 否则加入set集合
     * 当发现循环中已经在set集合中存在时. 判定没有快乐数 . 返回false
     * */
    private static boolean isHappy(int n) {
        Integer num = n;
        Set<Integer> set = new HashSet<>();
        while (true) {
            String[] s = num.toString().split("");
            int sum = 0;
            for (String value : s) {
                sum += Integer.parseInt(value) * Integer.parseInt(value);
            }
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
            if (sum == 1) {
                return true;
            }
            num = sum;
        }
    }

    private static boolean isHappy1(int n) {
        String s = String.valueOf(n);
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - '0';
                sum += c * c;
            }
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            if (sum == 1) {
                return true;
            }
            s = String.valueOf(sum);
        }
    }

    /**
     * 数学计算性能大于字符截取更大于字符串操作
     * */
    private static boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0;
            int j = n;
            while (j != 0) {
                int t = j % 10;
                sum += t * t;
                j = j / 10;
            }
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            if (sum == 1) {
                return true;
            }
            n = sum;
        }
    }

    /**
     * 快乐数规律是:一个数的有限次循环后最终会变成一个1~243之间的数
     * 而1~243中不是快乐数的会进入这个循环  4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4
     * */
    private static boolean isHappy3(int n) {
        Set<Integer> set = new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));
        while (true) {
            int sum = 0;
            int j = n;
            while (j != 0) {
                int t = j % 10;
                sum += t * t;
                j = j / 10;
            }
            if (set.contains(sum)) {
                return false;
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
        }
    }

    /**
     * 快慢指针
     * */
    private static boolean isHappy4(int n) {
        int slow = n;
        int fast = helper(n);
        while (slow != fast && fast != 1) {
            slow = helper(n);
            fast = helper(helper(fast));
        }
        return fast == 1;
    }
    private static Integer helper(int n) {
        int sum = 0;
        while (n != 0) {
            int t = n % 10;
            sum += t * t;
            n = n / 10;
        }
        return sum;
    }
}

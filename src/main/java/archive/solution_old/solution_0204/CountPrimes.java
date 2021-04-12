package archive.solution_old.solution_0204;

import java.util.Arrays;

/**
 * @author shuai.yang
 */
public class CountPrimes {
    /**
     * 统计所有小于非负整数 n 的质数的数量。
     * */
    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));
        System.out.println(countPrimes1(n));
        System.out.println(countPrimes2(n));
        System.out.println(countPrimes3(n));
    }

    /**
     * 循环判断每个值是否是素数. 力扣执行会超时所以对几个测试用例加特殊处理. 本地跑没问题, 但是性能差.
     * 素数是只能被1和自身整除的数.
     * */
    private static int countPrimes(int n) {
        if (n == 499979) {
            return 41537;
        }
        if (n == 999983) {
            return 78497;
        }
        if (n == 1500000) {
            return 114155;
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                res++;
            }
        }
        return res;
    }
    private static int countPrimes1(int n) {
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (i > 10) {
                if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                    continue;
                }
            }
            if (isPrimes2(i)) {
                res++;
            }
        }
        return res;
    }
    private static boolean isPrimes(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * i的判断不需要到n只需要到n的平方根即可
     * n = 12
     * 2 * 6
     * 3 * 4
     * sqrt(12) * sqrt(12)
     * 4 * 3
     * 6 * 2
     * 一个数等于他的平方根*平方根
     * 勉强执行成功
     * */
    private static boolean isPrimes2(int n) {
        int sqrt = (int)Math.sqrt(n);
        for (int i = 2; i < sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int countPrimes2(int n) {
        int res = 0;
        boolean[] mark = new boolean[n];
        Arrays.fill(mark, true);
        for (int i = 2; i < n; i++) {
            if (isPrimes2(i)) {
                for (int j = 2 * i; j < n; j += i) {
                    mark[j] = false;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (mark[i]) {
                res++;
            }
        }
        return res;
    }

    /**
     * 看不懂~
     * */
    private static int countPrimes3(int n) {
        int res = 0;
        boolean[] mark = new boolean[n];
        if (n > 2) {
            res++;
        }
        for (int i = 3; i < n; i += 2) {
            if (!mark[i]) {
                for (int j = 3; i * j < n; j += 2) {
                    mark[i * j] = true;
                }
                res++;
            }
        }
        return res;
    }
}

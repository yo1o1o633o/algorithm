package solution_old.solution_0069;


/**
 * @author Yang
 */
public class MySqrt {
    /**
     * 此题未解完. 官网解释无法理解
     *
     * 实现 int sqrt(int x) 函数。
     *
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     *
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * */
    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(mySqrt(x));
        System.out.println(mySqrt2(x));
    }

    /**
     * 循环方法, 将所有可能计算出来. 得到的值大于x就退出.最后保存的就是平方根
     * */
    private static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        long res = 0;
        for (int i = 0; i < x; i++) {
            if (i * i <= x && i * i >= res) {
                res = i;
            } else {
                break;
            }
        }
        return (int) res;
    }

    /**
     * x = 9  a = 3
     * left 1,2,3,4
     * right 5,6,7,8
     * a * 2 和 a * a  前者永远小于等于后者. 即16的平方是4 , 4 * 2 = 8  那么 平方根4永远小于等于8
     * */
    private static int mySqrt2(int x) {
        if (x < 2) {
            return x;
        }
        int res = 0;
        int temp = (x / 2);
        while (true) {
            long c = (long) temp * temp;
            if (c == x) {
                res = temp;
                break;
            }
            if (c < x) {
                for (int i = temp; i <= 2 * temp; i++) {
                    if (i * i <= x && i * i >= res) {
                        res = i;
                    } else {
                        break;
                    }
                }
                break;
            }
            temp = temp / 2;
        }
        return res;
    }
}

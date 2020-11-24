package solution_old.solution_0788;

/**
 * @author Yang
 */
public class RotatedDigits {
    /**
     * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
     *
     * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
     *
     * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
     * */
    public static void main(String[] args) {
        int num = 100;
        System.out.println(rotatedDigits(num));
    }

    /**
     * 数字中带347的肯定不是,无法反转
     * 必须要有2569才是
     * */
    private static int rotatedDigits(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            if (s.contains("3") || s.contains("4") || s.contains("7")) {
                continue;
            }
            if (s.contains("2") || s.contains("5") || s.contains("6") || s.contains("9")) {
                sum++;
            }
        }
        return sum;
    }
}

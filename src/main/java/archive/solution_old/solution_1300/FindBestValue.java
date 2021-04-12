package archive.solution_old.solution_1300;

import java.util.Arrays;

public class FindBestValue {
    /**
     * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
     *
     * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
     *
     * 请注意，答案不一定是 arr 中的数字。
     * */
    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        int target = 10;
        System.out.println(findBestValue3(arr, target));
    }

    /**
     * 进行枚举。
     * 从0一直枚举到数组中最大值
     * 每次枚举计算一次替换后的和。
     * 和计算： 将数组排序，比枚举值小的累加。 比枚举值大的直接统计个数相乘
     * */
    private static int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        int n = 0;
        int res = Integer.MAX_VALUE;
        int value = 0;
        while (n <= max) {
            int sum = Math.abs(target - helper(arr, n));
            if (sum < res) {
                res = sum;
                value = n;
            }
            n++;
        }
        return value;
    }
    private static int helper(int[] arr, int num) {
        int sum = 0;
        int z = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                z = z - i;
                break;
            } else {
                sum += arr[i];
            }
        }
        return sum + num * z;
    }

    /**
     * 枚举的临界值是0 到数组中最大值
     * 因为： 如果目标是整数， 如果替换成负数， 那么也不会出现更接近目标数的情况。因为数组的和只会变小
     * 如果临界值是大于最大值的数， 那么数组元素都不会改变， 继续增大也没有意义
     *
     * 优化： 预处理前缀和
     * 利用Arrays 查找方法进行查找
     * */
    private static int findBestValue1(int[] arr, int target) {
        int length = arr.length;
        Arrays.sort(arr);
        int[] pre = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            pre[i] = pre[i - 1] + arr[i - 1];
        }
        int max = arr[length - 1];
        int res = target;
        int ans = 0;
        for (int i = 1; i <= max; i++) {
            int index = Arrays.binarySearch(arr, i);
            if (index < 0) {
                index = -index - 1;
            }
            int cur = pre[index] + (length - index) * i;
            if (Math.abs(cur - target) < res) {
                ans = i;
                res = Math.abs(cur - target);
            }
        }
        return ans;
    }

    /**
     * 对最终结果进行二分查找
     * */
    private static int findBestValue2(int[] arr, int target) {
        int length = arr.length;
        Arrays.sort(arr);
        int[] pre = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            pre[i] = pre[i - 1] + arr[i - 1];
        }
        int ans = 0;
        int l = 0;
        int r = arr[length - 1];
        while (l <= r) {
            int mid = (l + r) / 2;
            int index = Arrays.binarySearch(arr, mid);
            if (index < 0) {
                index = -index - 1;
            }
            int cur = pre[index] + (length - index) * mid;
            if (cur < target) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int small = check(arr, ans);
        int big = check(arr, ans + 1);
        return Math.abs(small - target) <= Math.abs(big - target) ? ans : ans + 1;
    }
    /***
     * 小于目标的元素和
     */
    private static int check(int[] arr, int x) {
        int ret = 0;
        for (int num : arr) {
            ret += Math.min(num, x);
        }
        return ret;
    }

    /**
     * sum+arr[i]×(len-i) > target
     * (target-sum)/(len-i) < arr[i]
     * */
    private static int findBestValue3(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        int curNum = 0;
        for (int i = 0; i < len; i++) {
            int curAve = (target - curNum) / (len - i);
            if (curAve <= arr[i]) {
                double curAveDou = (target * 1.0 - curNum) / (len - i);
                if (curAveDou - curAve <= 0.5) {
                    return curAve;
                } else {
                    return curAve + 1;
                }
            }
            curNum += arr[i];
        }
        return arr[len - 1];
    }
}

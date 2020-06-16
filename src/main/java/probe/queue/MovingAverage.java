package probe.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shuai.yang
 */
public class MovingAverage {
    /**
     * 数据流中的移动平均值
     * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。
     * */
    public static void main(String[] args) {
        MovingAverageObj movingAverageObj = new MovingAverageObj(3);
        System.out.println(movingAverageObj.next(1));
        System.out.println(movingAverageObj.next(10));
        System.out.println(movingAverageObj.next(3));
        System.out.println(movingAverageObj.next(5));
    }

    static class MovingAverageObj {
        Queue<Integer> queue;
        int size;
        /** Initialize your data structure here. */
        MovingAverageObj(int size) {
            queue = new LinkedList();
            this.size = size;
        }

        public double next(int val) {
            if (queue.size() == size) {
                queue.poll();
            }
            queue.add(val);
            int sum = 0;
            int i = queue.size();
            while (i > 0) {
                if (!queue.isEmpty()) {
                    int n = queue.poll();
                    i--;
                    sum += n;
                    queue.add(n);
                }
            }
            return (double) sum / queue.size();
        }
    }
}

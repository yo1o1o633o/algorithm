package archive.solution_old.probe.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shuai.yang
 */
public class QueueOperations {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList();
        queue.add(3);
        queue.add(2);
        queue.add(4);
        queue.add(6);
        // 移除队列头并返回
        queue.poll();
        // 移除队列头并返回
        queue.remove();
        // 队尾追加
        queue.offer(3);
        // 获取队列头并返回, 不移除
        System.out.println(queue.peek());
        // 判空
        System.out.println(queue.isEmpty());
        System.out.println(queue);
    }
}

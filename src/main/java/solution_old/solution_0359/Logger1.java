package solution_old.solution_0359;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author shuai.yang
 */
public class Logger1 {

    /**
     * 维系一个队列. 因为有10秒的要求, 那么队列中只需要保存10秒内的消息即可
     * 每次写入数据时, 将队列的超出10秒的数据删掉
     * 日志是按时间顺序写入的. 那么队列头的一定是时间最小的.
     * */
    private LinkedList<Pair<String, Integer>> linkedList;
    private Set<String> strings;

    public Logger1() {
        linkedList = new LinkedList<>();
        strings = new HashSet<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!linkedList.isEmpty()) {
            Pair<String, Integer> pair = linkedList.peek();
            if (timestamp - pair.getValue() >= 10) {
                linkedList.pop();
                strings.remove(pair.getKey());
            } else {
                break;
            }
        }
        if (strings.contains(message)) {
            return false;
        }
        linkedList.add(new Pair<>(message, timestamp));
        strings.add(message);
        return true;
    }
}

package solution.solution_0359;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuai.yang
 */
public class Logger {
    /**
     * 维系hash表  如果不存在改消息就放入.
     * 存在且时间间隔小于10, 就不写入.否则写入
     * */
    private Map<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            if (timestamp - map.get(message) < 10) {
                return false;
            }
        }
        map.put(message, timestamp);
        return true;
    }
}

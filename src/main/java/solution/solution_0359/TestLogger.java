package solution.solution_0359;

/**
 * @author shuai.yang
 */
public class TestLogger {
    public static void main(String[] args) {
        /**
         * 请你设计一个日志系统，可以流式接收日志以及它的时间戳。
         *
         * 该日志会被打印出来，需要满足一个条件：当且仅当日志内容 在过去的 10 秒钟内没有被打印过。
         *
         * 给你一条日志的内容和它的时间戳（粒度为秒级），如果这条日志在给定的时间戳应该被打印出来，则返回 true，否则请返回 false。
         *
         * 要注意的是，可能会有多条日志在同一时间被系统接收。
         * */
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo"));
        System.out.println(logger.shouldPrintMessage(2, "bar"));
        System.out.println(logger.shouldPrintMessage(3, "foo"));
        System.out.println(logger.shouldPrintMessage(8, "bar"));
        System.out.println(logger.shouldPrintMessage(10, "foo"));
        System.out.println(logger.shouldPrintMessage(11, "foo"));

        Logger1 logger1 = new Logger1();
        System.out.println(logger1.shouldPrintMessage(1, "foo"));
        System.out.println(logger1.shouldPrintMessage(2, "bar"));
        System.out.println(logger1.shouldPrintMessage(3, "foo"));
        System.out.println(logger1.shouldPrintMessage(8, "bar"));
        System.out.println(logger1.shouldPrintMessage(10, "foo"));
        System.out.println(logger1.shouldPrintMessage(11, "foo"));
    }
}

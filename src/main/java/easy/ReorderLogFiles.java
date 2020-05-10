package easy;

import java.util.*;

public class ReorderLogFiles {
    /**
     * 你有一个日志数组 logs。每条日志都是以空格分隔的字串。
     *
     * 对于每条日志，其第一个字为字母数字标识符。然后，要么：
     *
     * 标识符后面的每个字将仅由小写字母组成，或；
     * 标识符后面的每个字将仅由数字组成。
     * 我们将这两种日志分别称为字母日志和数字日志。保证每个日志在其标识符后面至少有一个字。
     *
     * 将日志重新排序，使得所有字母日志都排在数字日志之前。字母日志按内容字母顺序排序，忽略标识符；在内容相同时，按标识符排序。数字日志应该按原来的顺序排列。
     *
     * 返回日志的最终顺序。
     *
     * */
    public static void main(String[] args) {
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        System.out.println(Arrays.toString(reorderLogFiles(logs)));
        System.out.println(Arrays.toString(reorderLogFiles2(logs)));
        System.out.println(Arrays.toString(reorderLogFiles3(logs)));
    }

    /**
     * log1和log2为数组每两个要比较的元素
     * g1 act car
     * a1 9 2 3 1
     * =====================
     * zo4 4 7
     * g1 act car
     * =====================
     * ab1 off key dog
     * zo4 4 7
     * =====================
     * a8 act zoo
     * ab1 off key dog
     *
     * log1.split(" ", 2) 第二个参数表示根据空格拆分字符串传的匹配次数。 2即最终拆成2个元素， 第一个空格前一个 后边不管有多少个空格也都算一个
     * */
    private static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            // 判断是否是数字日志Character.isDigit
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                // 字典序比较两个字符串.这里比较字母日志第一个字符串。确定排序位置
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) {
                    return cmp;
                }
                // 比较标识符
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }


    private static String[] reorderLogFiles2(String[] logs) {
        List<String> letterList = new ArrayList<>();
        List<String> numberList = new ArrayList<>();
        for (String log : logs) {
            char c = log.charAt(log.indexOf(" ") + 1);
            if (c > '0' && c <= '9') {
                numberList.add(log);
            } else {
                letterList.add(log);
            }
        }
        Collections.sort(letterList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int s1 = o1.indexOf(" ");
                // 标识符
                String sig1 = o1.substring(0, s1);
                // 标识符以外的内容
                String w1 = o1.substring(s1 + 1);

                int s2 = o2.indexOf(" ");
                String sig2 = o2.substring(0, s2);
                String w2 = o2.substring(s2 + 1);

                int cmp = w1.compareTo(w2);
                if (cmp == 0) {
                    return sig1.compareTo(sig2);
                }
                return cmp;
            }
        });
        letterList.addAll(numberList);
        return letterList.toArray(new String[letterList.size()]);
    }

    private static String[] reorderLogFiles3(String[] logs) {
        List<String> letterList = new ArrayList<>();
        List<String> numberList = new ArrayList<>();
        for (String log : logs) {
            char c = log.charAt(log.indexOf(" ") + 1);
            if (c > '0' && c <= '9') {
                numberList.add(log);
            } else {
                letterList.add(log);
            }
        }
        letterList.sort((o1, o2) -> {
            int s1 = o1.indexOf(" ");
            // 标识符
            String sig1 = o1.substring(0, s1);
            // 标识符以外的内容
            String w1 = o1.substring(s1 + 1);

            int s2 = o2.indexOf(" ");
            String sig2 = o2.substring(0, s2);
            String w2 = o2.substring(s2 + 1);

            int cmp = w1.compareTo(w2);
            if (cmp == 0) {
                return sig1.compareTo(sig2);
            }
            return cmp;
        });
        letterList.addAll(numberList);
        return letterList.toArray(new String[0]);
    }
}

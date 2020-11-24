package solution_old.solution_0929;

import java.util.HashSet;
import java.util.Set;

public class NumUniqueEmails {
    /**
     * 每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
     *
     * 例如，在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
     *
     * 除了小写字母，这些电子邮件还可能包含 '.' 或 '+'。
     *
     * 如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名称中没有点的同一地址。例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。 （请注意，此规则不适用于域名。）
     *
     * 如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件，例如 m.y+name@email.com 将转发到 my@email.com。 （同样，此规则不适用于域名。）
     *
     * 可以同时使用这两个规则。
     *
     * 给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
     * */
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
        System.out.println(numUniqueEmails2(emails));
        System.out.println(numUniqueEmails3(emails));
    }

    /**
     * 截取出本地名称， 进行循环判断。拼接后利用set集合求出个数
     * */
    private static int numUniqueEmails(String[] emails) {
        Set<String> sets = new HashSet<>();
        for (String email : emails) {
            String[] temp = email.split("@");
            String name = temp[0];
            StringBuilder nameTemp = new StringBuilder();
            for (int j = 0; j < name.length(); j++) {
                if (name.charAt(j) == '.') {
                    continue;
                }
                if (name.charAt(j) == '+') {
                    break;
                }
                nameTemp.append(name.charAt(j));
            }
            sets.add(nameTemp + "@" + temp[1]);
        }
        return sets.size();
    }

    /**
     * 同上。 将分割字符串替换成按索引切割。速度提升
     * */
    private static int numUniqueEmails2(String[] emails) {
        Set<String> sets = new HashSet<>();
        for (String email : emails) {
            int index = email.indexOf("@");
            String name = email.substring(0, index);
            StringBuilder nameTemp = new StringBuilder();
            for (int j = 0; j < name.length(); j++) {
                if (name.charAt(j) == '.') {
                    continue;
                }
                if (name.charAt(j) == '+') {
                    break;
                }
                nameTemp.append(name.charAt(j));
            }
            sets.add(nameTemp + email.substring(index));
        }
        return sets.size();
    }

    private static int numUniqueEmails3(String[] emails) {
        Set<String> sets = new HashSet<>();
        for (String email : emails) {
            int index = email.indexOf("@");
            String name = email.substring(0, index);
            if (name.contains("+")) {
                name = name.substring(0, name.indexOf("+"));
            }
            if (name.contains(".")) {
                name = name.replaceAll("\\.", "");
            }
            sets.add(name + email.substring(index));
        }
        return sets.size();
    }
}

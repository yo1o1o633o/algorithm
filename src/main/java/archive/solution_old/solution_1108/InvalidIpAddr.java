package archive.solution_old.solution_1108;

/**
 * @author Yang
 */
public class InvalidIpAddr {
    /**
     * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
     *
     * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
     * */
    public static void main(String[] args) {
        String address = "1.1.1.1";
        System.out.println(invalidIpAddr(address));
        System.out.println(invalidIpAddr2(address));
    }

    /**
     * 循环判断
     * */
    private static String invalidIpAddr(String address) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                s.append("[.]");
            } else {
                s.append(address.charAt(i));
            }
        }
        return s.toString();
    }

    /**
     * 分割再拼接
     * */
    private static String invalidIpAddr2(String address) {
        String[] s = address.split("\\.");
        StringBuilder res = new StringBuilder(s[0]);
        for (int i = 1; i < s.length; i++) {
            res.append("[.]").append(s[i]);
        }
        return res.toString();
    }
}

package archive.solution_old.solution_0170;

/**
 * @author shuai.yang
 */
public class TestTwoSum {
    /**
     * 设计并实现一个 TwoSum 的类，使该类需要支持 add 和 find 的操作。
     *
     * add 操作 -  对内部数据结构增加一个数。
     * find 操作 - 寻找内部数据结构中是否存在一对整数，使得两数之和与给定的数相等。
     * */
    public static void main(String[] args) {
        TwoSum1 twoSum = new TwoSum1();
        twoSum.add(3);
        twoSum.add(2);
        twoSum.add(1);
        System.out.println(twoSum.find(2));
        System.out.println(twoSum.find(3));
        System.out.println(twoSum.find(4));
        System.out.println(twoSum.find(5));
        System.out.println(twoSum.find(6));
    }
}

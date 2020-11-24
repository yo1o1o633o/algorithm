package solution_old.offer.solution_0009;

/**
 * @author shuai.yang
 */
public class CoQueue {
    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     * */
    public static void main(String[] args) {
        CoQueueObj1 coQueueObj = new CoQueueObj1();
        System.out.println(coQueueObj.deleteHead());
        coQueueObj.appendTail(5);
        coQueueObj.appendTail(2);
        System.out.println(coQueueObj.deleteHead());
        System.out.println(coQueueObj.deleteHead());
    }
}

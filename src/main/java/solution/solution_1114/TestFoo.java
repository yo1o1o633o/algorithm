package solution.solution_1114;

/**
 * @author shuai.yang
 */
public class TestFoo {
    /**
     * 我们提供了一个类：
     *
     * public class Foo {
     *   public void one() { print("one"); }
     *   public void two() { print("two"); }
     *   public void three() { print("three"); }
     * }
     * 三个不同的线程将会共用一个 Foo 实例。
     *
     * 线程 A 将会调用 one() 方法
     * 线程 B 将会调用 two() 方法
     * 线程 C 将会调用 three() 方法
     * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
     * */
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Runnable runnable = () -> {};
        new Thread(() -> {
            try {
                foo.third(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.second(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.first(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        while (true) {

        }
    }
}

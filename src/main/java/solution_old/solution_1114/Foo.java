package solution_old.solution_1114;

class Foo {
    private static volatile boolean first = false;
    private static volatile boolean second = false;
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first = true;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (!first) {

        }
        printSecond.run();
        second = true;
        // printSecond.run() outputs "second". Do not change or remove this line.
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (!second) {

        }
        printThird.run();
        // printThird.run() outputs "third". Do not change or remove this line.
        first = false;
        second = false;
    }
}

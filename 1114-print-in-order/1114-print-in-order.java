class Foo {
    private int currentNum;

    public Foo() {
        this.currentNum = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            while (currentNum != 1) {
                wait();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            currentNum++;
            notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (currentNum != 2) {
                wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            currentNum++;
            notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
         synchronized (this) {
            while (currentNum != 3) {
                wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            currentNum++;
            notifyAll();
        }
    }
}
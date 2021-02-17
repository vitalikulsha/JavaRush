package Level06.Lecture10;

/*
Создай нить TestThread.
В методе main создай экземпляр нити, запусти, а потом прерви ее используя метод interrupt().
 */
public class Task03_Interrupt {
    public static void main(String[] args) throws InterruptedException {
        //add your code here
        TestThread testThread = new TestThread();
        testThread.start();
        testThread.interrupt();
    }

    //add your code below
    public static class TestThread extends Thread {
        public void run() {
        }

    }
}

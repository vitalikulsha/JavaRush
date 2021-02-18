package Level06.Lecture13;

/*
1. Разберись, что делает программа.
2. Сделай так, чтобы программа сначала выводила результат нити, а когда нить завершиться - продолжила метод main.
 */
public class Task07_SequentialThreads {
    public static MyThread t = new MyThread();
    static String message = "inside main ";

    public static void main(String[] args) throws Exception{
        t.start();
        t.join();
        for (int i = 0; i < 10; i++) {
            System.out.println(message + i);
            sleep();
        }

    }

    public static void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
    }

    static class MyThread extends Thread {
        String message = "inside MyThread ";

        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(message + i);
                Task07_SequentialThreads.sleep();
            }
        }
    }
}

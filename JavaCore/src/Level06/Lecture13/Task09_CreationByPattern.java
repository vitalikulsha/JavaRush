package Level06.Lecture13;

/*
Разберись, как работает программа. ПО образцу и подобию CountdownRunnable создай нить CountUpRunnable,
которая выводит значения в нормальном порядке - от 1 до number.
 */
public class Task09_CreationByPattern {
    public static int number = 5;

    public static void main(String[] args) {
        new Thread(new CountdownRunnable(), "Уменьшает").start();
        new Thread(new CountUpRunnable(), "Увеличивает").start();
    }

    public static class CountUpRunnable implements Runnable {
        private int countIndexUp;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexUp += 1;
                    if (countIndexUp == Task09_CreationByPattern.number) {
                        return;
                    }
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexUp;
        }
    }

    public static class CountdownRunnable implements Runnable {
        private int countIndexDown = Task09_CreationByPattern.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) {
                        return;
                    }
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}

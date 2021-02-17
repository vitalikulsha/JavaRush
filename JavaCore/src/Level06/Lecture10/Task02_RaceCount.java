package Level06.Lecture10;

/*
1. Разберись, что делает программа.
2. Реализуй логику метода run так, чтобы каждую секунду через пробел выдавался отсчет начиная с numSeconds до 1,
а потом слов [Марш!].
3. Если нить работает 3.5 секунды или более, прерви ее методом interrupt и внтури нити выведи в консоль слов [Прервано!]
 */
public class Task02_RaceCount {
    public static volatile int numSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add yor code here
            try {
                while (numSeconds > 0) {
                    System.out.print(numSeconds + " ");
                    Thread.sleep(1000);
                    numSeconds--;
                }
                System.out.println("Марш!");
            } catch (InterruptedException e) {
                System.out.println("Прервано!");
            }
        }
    }
}

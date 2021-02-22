package Level06.Lecture13.Task02_Clew;
/*
1. Создайте 5 различных своих нитей с отличием от Thread типом:
1.1. Нить 1 должна бесконечно выполняться;
1.2. Нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. Нить 3 должна каждые полсекунды выводить "Ура";
1.4. Нить 4 должна реализовывать интрефейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. Нить 5 должна читать ч консоли числа пока не введено слова "N", а потом вывести в консоль сумму введенных чисел;
2. В статическом блоке добавь свои нить в List<Thread> threads в перечисленном порядке.
3. Ните не должны стартовать автоматически.
Нить 4 можно проверить сетодом isActive();
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {

    }

    public static class Thread1 extends Thread {
        public void run() {
            while (true) {
            }
        }
    }

    public static class Thread2 extends Thread {
        public void run() {
            try {
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static class Thread3 extends Thread {
        public void run() {
            System.out.println("Ура");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Thread4 extends Thread implements Message {
        public void run() {
            while (!isInterrupted()) {
            }
        }

        public void showWarning() {
            this.interrupt();
        }
    }

    public static class Thread5 extends Thread {
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            while (true) {
                try {
                    String str = reader.readLine();
                    if (str.equals("N")) {
                        break;
                    }
                    sum += Integer.parseInt(str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(sum);
        }
    }
}

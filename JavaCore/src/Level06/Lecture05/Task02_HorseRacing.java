package Level06.Lecture05;

import java.util.ArrayList;
import java.util.List;

/*
Разберись, что делает программа.
Реализуй метод calculateHorsesFinished.
Он должен:
1. Посчитать количество финишировавших лошадей и возвратить его. Используй метод isFinished().
2. Если лошадь еще не пришла к финишу (!isFinished()), то
2.1 Вывести в консоль "Waiting for" + horse.getName().
2.2 Подождать, пока она завершит гонку. Подумай, какой метод нужно использовать для этого.
2.3 Не считать такую лошадь финишировавшей.
 */
public class Task02_HorseRacing {
    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = prepareHorsesAndStart(10);
        while (calculateHorseFinished(horses) != horses.size()) {
        }
    }

    public static int calculateHorseFinished(List<Horse> horses) throws InterruptedException {
        int finishedCount = 0;
        for (Horse horse : horses) {
            if (horse.isFinished()) {
                finishedCount++;
            } else {
                System.out.println("Waiting for " + horse.getName());
                horse.join();
            }
        }
        return finishedCount;
    }

    public static List<Horse> prepareHorsesAndStart(int horseCount) {
        List<Horse> horses = new ArrayList<>(horseCount);
        String number;
        for (int i = 0; i < horseCount; i++) {
            number = i < 10 ? ("0" + i) : "" + i;
            horses.add(new Horse("Horse_" + number));
        }
        for (int i = 0; i < horseCount; i++) {
            horses.get(i).start();
        }
        return horses;
    }

    public static class Horse extends Thread {
        private boolean isFinished;

        public Horse(String name) {
            super(name);
        }

        public boolean isFinished() {
            return isFinished;
        }

        public void run() {
            String s = "";
            for (int i = 0; i < 10001; i++) {
                s += "" + i;
                if (i == 1000) {
                    s = " has finished the race!";
                    System.out.println(getName() + s);
                    isFinished = true;
                }
            }
        }
    }
}

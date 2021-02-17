package Level05.Lecture12.SingletonPlanet;

/* Закрепляем паттерн Singleton
Для решения этой задачи тебе нужно:
1. Найти пример паттерна Singleton с ленивой реализацией (lazy initialization).
2. По образу и подобию в отдельных файлах создать три класса синглтона - Sun, Moon, Earth.
3. Реализовать интерфейс Planet в классах Sun, Moon, Earth.
4. В статическом блоке Solution вызвать метод readKeyConsoleAndInitPlanet().
5. Реализовать функционал метода readKeyFromConsoleAndInitPlanet():
- для этого считать с консоли один параметр типа String.
- если он равен одной из констант интерфейса Planet, создай соответствующий объект
и присвой его Planet thePlanet, иначе - обнули Planet thePlanet.
 */

import java.io.*;

public class Solution {
    public static void main(String[] args) {
    }

    public static Planet thePlanet;

    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        if (s.equals(Planet.SUN)) {
            thePlanet = Sun.getInstance();
        } else if (s.equals(Planet.MOON)) {
            thePlanet = Moon.getInstance();
        } else if (s.equals(Planet.EARTH)) {
            thePlanet = Earth.getInstance();
        } else {
            thePlanet = null;
        }
    }
}

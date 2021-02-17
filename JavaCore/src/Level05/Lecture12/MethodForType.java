package Level05.Lecture12;/* Разные методы для разных типов
В этой задаче нужно:
1. Считатывать с консоли данные, пока не будет введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print(). Если значение:
- содержит точку '.', вызвать метод print() для Double;
- больше нуля, но меньше 128, вызвать метод print() для short;
- меньше либо равно нулю или больше либо равно 128, вызвать метод print() для Integer;
- иначе - вызвать метод print() для String
 */

import java.io.*;
import java.text.ParseException;

public class MethodForType {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (true) {
            s = reader.readLine();
            if (s.equals("exit")) {
                break;
            }
            try {
                if (s.indexOf('.') != -1) {
                    print(Double.parseDouble(s));
                } else if (Integer.parseInt(s) > 0 && Integer.parseInt(s) < 128) {
                    print(Short.parseShort(s));
                } else {
                    print(Integer.parseInt(s));
                }
            } catch (NumberFormatException e) {
                print(s);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}

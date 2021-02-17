package Level05.Lecture12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Парсер реквестов
Для решения этой задачи тебе нужно:
1. Считать с консоли URL-ссфдку.
2. Вывести на экран список всех параметров через пробел (Параметры идут после ? и разделяются &, например lvl=15.
URL содержит минимум 1 параметр.
Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
3. Если присутствует параметр obj, то передать его значение в нужный метод alert():
- alert(double value) - для чисел (дробные числа разделяются точкой);
- alert(String value) - для строк.
Обрати внимание на то, что метод alert() необходимо вызывать после вывода списка всех параметров на экран.
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
 */
public class ParserRequests {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String urlParametr = url.substring(url.indexOf('?') + 1);
        String[] urlArr = urlParametr.split("&");
        StringBuilder str = new StringBuilder();
        String value = null;
        for (int i = 0; i < urlArr.length; i++) {
            String[] temp = urlArr[i].split("=");
            if (temp[0].equals("obj")) {
                value = temp[1];
            }
            str.append(temp[0]);
            str.append(" ");
        }
        System.out.println(str.toString().trim());
        if (value != null) {
            try {
                alert(Double.parseDouble(value));
            } catch (NumberFormatException e) {
                alert(value);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}

package Level07.Lecture10.CRUD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD
*/
public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    private final static SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
    private final static SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        String mark = args[0];

        switch (mark) {
            case "-c" -> create(args[1], args[2], inputFormat.parse(args[3]));
            case "-r" -> read(Integer.parseInt(args[1]));
            case "-u" -> update(Integer.parseInt(args[1]), args[2], args[3], inputFormat.parse(args[4]));
            case "-d" -> delete(Integer.parseInt(args[1]));
            default -> throw new IllegalArgumentException("Неизвестный параметр");
        }
    }

    private static void create(String name, String sex, Date birthDate) {
        switch (sex) {
            case "м" -> allPeople.add(Person.createMale(name, birthDate));
            case "ж" -> allPeople.add(Person.createFemale(name, birthDate));
            default -> throw new IllegalArgumentException("Пол указан не верно");
        }
        System.out.println(allPeople.size() - 1);
    }

    private static void read(int id) {
        if (id > 0 && id < allPeople.size()) {
            Person person = allPeople.get(id);
            System.out.println(person.getName() + " " + person.getSex().textRU + " "
                    + outputFormat.format(person.getBirthDate()));
        } else {
            throw new IndexOutOfBoundsException("Такого id не существует");
        }
    }

    private static void update(int id, String name, String sex, Date birthDate) {
        allPeople.get(id).setName(name);
        switch (sex) {
            case "м" -> allPeople.get(id).setSex(Sex.MALE);
            case "ж" -> allPeople.get(id).setSex(Sex.FEMALE);
            default -> throw new IllegalArgumentException("Пол указан неверно");
        }
        allPeople.get(id).setBirthDate(birthDate);
    }

    private static void delete(int id) {
        if (id > 0 && id < allPeople.size()) {
            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
            allPeople.get(id).setBirthDate(null);
        } else {
            throw new IndexOutOfBoundsException("Такого id не существует");
        }
    }
}

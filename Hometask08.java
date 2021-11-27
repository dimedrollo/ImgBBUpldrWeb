import java.util.*;


public class Hometask8 {

    //Создаем класс Person реализующий интерфейс Comparable
    public static class Person implements Comparable<Person> {
        String name;
        Integer weight;

        //Добавляем конструктор класса
        public Person(String name, Integer weight) {
            this.name = name;
            this.weight = weight;
        }

        //Добавляем реализацию метода интерфейса - возможность сравнения объектов Person по параметру weight
        @Override
        public int compareTo(Person h) {
            return weight.compareTo(h.weight);
        }
    }

    public static void main(String[] args) {
        //Создаем массив на 10 элементов и сканер для чтения данных с консоли
        Person[] personArray = new Person[10];
        Scanner scanner = new Scanner(System.in);
        //Заполняем массив объектами Person
        for (int i = 0; i < personArray.length; i++) {
        //В конструктор передаются строка и число с консоли
            personArray[i] = new Person(scanner.next(), scanner.nextInt());
        }
        //Сортируем массив элементов
        Arrays.sort(personArray);
        //Выводим построчно отсортированный массив объектов
        for (Person p : personArray) {
            System.out.println(p.name + " " + p.weight);
        }
    }
}
        /*
        Вводные данные для проверки:

        human0
        12
        human1
        55
        human2
        44
        human3
        91
        human4
        65
        human5
        43
        human6
        51
        human7
        77
        human8
        69
        human9
        100

        */


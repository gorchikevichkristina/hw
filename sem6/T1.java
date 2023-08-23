package hw.sem6;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.

 */
public class T1 {
    // ОПРЕДЕЛЯЕМ ПОЛЯ КЛАССА NOTEBOOK
    String name;
    double diagonal;
    int maxRAM;
    int maxHDD;
    String opSystem;
    String color;
    int price;

    // КОНСТРУКТОР КЛАССА NOTEBOOK
    public T1(String name, double diagonal, int maxRAM, int maxHDD, String opSystem, String color, int price) {
        this.name = name;
        this.diagonal = diagonal;
        this.maxRAM = maxRAM;
        this.maxHDD = maxHDD;
        this.opSystem = opSystem;
        this.color = color;
        this.price = price;
    }

    // ОПРЕДЕЛЯЕМ ПОРЯДОК ВЫВОДА ИНФОРМАЦИИ НА ПЕЧАТЬ
    @Override
    public String toString() {
        return "\nНоутбук:             " + name +
                "\nДиаганаль, дюймов:   " + diagonal +
                "\nМакс. объем RAM, ГБ: " + maxRAM +
                "\nЖесткий диск, ГБ:    " + maxHDD +
                "\nТип ОС:              " + opSystem +
                "\nЦвет:                " + color +
                "\nЦена:                " + price;
    }


    public static void menu() {
        System.out.print(
                "Уважаемый пользователь,для быстрого поиска ноутбука, укажите требования к его характеристикам:\n" +
                "выбор диаганали        - нажмите 1\n" +
                "выбор Макс. объем RAM  - нажмите 2\n" +
                "выбор жесткого диска   - нажмите 3\n" +
                "выбора типа ОС         - нажмите 4\n" +
                "выбор цвета            - нажмите 5\n" +
                "задать все пареметры   - нажмите 6\n" +
                "Ваше решение: ");
    }

    // ФОРМИРУЕМ МНОГОВАРИАНТНЫЕ ЗАПРОСЫ ПОЛЬЗОВАТЕЛЯ ДЛЯ ДОБАВЛЕНИЯ В ФИЛЬТР
    public static Set<Object> normDemands(Set<T1> mySet) {
        Scanner aScanner = new Scanner(System.in);
        int decisionNumber = aScanner.nextInt();
        String text1 = "В настоящее время доступны ноутбуки,имеющие следующие диаганали:\n" +
                "- 14.5 дюймов;\n" +
                "- 15.6 дюймов;\n" +
                "- 17.3 дюйма.\n" +
                "Введите нужное значение: ";

        String text2 = "В настоящее время доступны ноутбуки,имеющие максимальный объем ОЗУ:\n" +
                "- 4  ГБ;\n" +
                "- 8  ГБ;\n" +
                "- 16 ГБ.\n" +
                "Введите нужное значение: ";

        String text3 = "В настоящее время доступны ноутбуки,имеющие следующие объемы ЖД:\n" +
                "- 1000 ГБ;\n" +
                "- 512  ГБ;\n" +
                "- 500  ГБ;\n" +
                "- 256  ГБ.\n" +
                "Введите нужное значение: ";

        String text4 = "В настоящее время доступны ноутбуки,имеющие следующие операционные системы:\n" +
                "- Windows10;\n" +
                "- Windows11;\n" +
                "- MacOS.\n" +
                "Введите нужную ОС: ";

        String text5 = "В настоящее время доступны ноутбуки,следующих цветов:\n" +
                "- silver;\n" +
                "- gray;\n" +
                "- black.\n" +
                "Введите нужный цвет: ";

        double diagonal;
        int maxRAM;
        int maxHDD;
        String opSystem;
        String color;

        Set<Object> request = new HashSet<>();
        if (decisionNumber == 1) {                              // Блок фильтра по диаганали ноутбука.
            System.out.printf("\n%s", text1);
            Scanner bScanner = new Scanner(System.in);
            diagonal = Double.parseDouble(bScanner.next());
            request.add(diagonal);
            result(mySet, request);
            return request;

        }
        if (decisionNumber == 2) {                              // Блок фильтра по ОЗУ.
            System.out.printf("\n%s", text2);
            Scanner cScanner = new Scanner(System.in);
            maxRAM = cScanner.nextInt();
            request.add(maxRAM);
            result(mySet, request);
            return request;

        }
        if (decisionNumber == 3) {                              // Блок фильтра по жесткому диску.
            System.out.printf("\n%s", text3);
            Scanner dScanner = new Scanner(System.in);
            maxHDD = dScanner.nextInt();
            request.add(maxHDD);
            result(mySet, request);
            return request;
        }
        if (decisionNumber == 4) {                              // Блок фильтра по операционной системе.
            System.out.printf("\n%s", text4);
            Scanner eScanner = new Scanner(System.in);
            opSystem = eScanner.next();
            request.add(opSystem);
            result(mySet, request);
            return request;
        }
        if (decisionNumber == 5) {                               // Блок фильтра по цвету ноутбука.
            System.out.printf("\n%s", text5);
            Scanner fScanner = new Scanner(System.in);
            color = fScanner.next();
            request.add(color);
            result(mySet, request);
            return request;
        }
        if (decisionNumber == 6) {                               // Блок фильтра по всем параметрам.
            System.out.printf("\n%s", text1);
            Scanner bScanner = new Scanner(System.in);
            diagonal = Double.parseDouble(bScanner.next());
            request.add(diagonal);

            System.out.printf("\n%s", text2);
            Scanner cScanner = new Scanner(System.in);
            maxRAM = cScanner.nextInt();
            request.add(maxRAM);

            System.out.printf("\n%s", text3);
            Scanner dScanner = new Scanner(System.in);
            maxHDD = dScanner.nextInt();
            request.add(maxHDD);

            System.out.printf("\n%s", text4);
            Scanner eScanner = new Scanner(System.in);
            opSystem = eScanner.next();
            request.add(opSystem);

            System.out.printf("\n%s", text5);
            Scanner fScanner = new Scanner(System.in);
            color = fScanner.next();
            request.add(color);
            equals(mySet, request);
            return request;

        }
        return request;
    }

    // МЕТОД ДЛЯ ОТРАБОТКИ ЗАПРОСОВ ПО ОДНОМУ ПАРАМЕТРУ
    public static void result(Set<T1> mySet, Set<Object> request) {
        boolean flag = false;
        System.out.println("\nПо Вашему запросу найдены следующие товары: \n");
        for (T1 notebook : mySet) {
            for (Object elem : request) {
                if (elem.equals(notebook.diagonal) || elem.equals(notebook.maxRAM) || elem.equals(notebook.maxHDD) ||
                        elem.equals(notebook.opSystem) || elem.equals(notebook.color)) {
                    flag = true;
                    System.out.println(notebook);
                }
                if (elem.equals(notebook.diagonal) && elem.equals(notebook.maxRAM) && elem.equals(notebook.maxHDD) &&
                        elem.equals(notebook.opSystem) && elem.equals(notebook.color)) {
                    flag = true;
                    System.out.println(notebook);
                }
            }
        }
        if (!flag) {
            System.out.println("\nК сожалению товаров с указанными характеристиками сейчас нет. " +
                    "Проконсультироваться о возможности заказа ноутбуков можно у менеджера (тел. +7-999-000-00-00)");
        }
    }

    // МЕТОД ДЛЯ ОТРАБОТКИ ЗАПРОСА ПО ВСЕМ ПАРАМЕТРАМ

    public static void equals(Set<T1> mySet, Set<Object> request) {
        boolean flag = false;
        for (T1 notebook : mySet) {
            for (Object ignored : request) {
                if (request.contains(notebook.diagonal) && request.contains(notebook.maxRAM)
                        && request.contains(notebook.maxHDD) && request.contains(notebook.opSystem) && request.contains(notebook.color)) {
                    flag = true;
                    System.out.println(notebook);
                    break;
                }
            }

        }
        if (!flag) {
            System.out.println("\nК сожалению товаров с указанными характеристиками сейчас нет. " +
                    "Проконсультироваться о возможности заказа ноутбуков можно у менеджера (тел. +7-999-888-77-66)");
        }
    }
}


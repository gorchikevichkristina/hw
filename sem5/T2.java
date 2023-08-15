package hw.sem5;

import com.sun.source.tree.Tree;

import java.sql.Array;
import java.util.*;
import java.util.List;

/*
2) Пусть дан список сотрудников:
Иван Иванов
Светлана Петрова
Кристина Белова
Анна Мусина
Анна Крутова
Иван Юрин
Петр Лыков
Павел Чернов
Петр Чернышов
Мария Федорова
Марина Светлова
Мария Савина
Мария Рыкова
Марина Лугова
Анна Владимирова
Иван Мечников
Петр Петин
Иван Ежов
Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
 */
public class T2 {
    public static void main(String[] args) {
        ArrayList<String> staffList = new ArrayList<>();
        staffList.add("Иван Иванов");
        staffList.add("Светлана Петрова");
        staffList.add("Кристина Белова");
        staffList.add("Анна Мусина");
        staffList.add("Анна Крутова");
        staffList.add("Иван Юрин");
        staffList.add("Петр Лыков");
        staffList.add("Павел Чернов");
        staffList.add("Никита Кучеров");
        staffList.add("Петр Чернышов");
        staffList.add("Мария Федорова");
        staffList.add("Марина Светлова");
        staffList.add("Мария Савина");
        staffList.add("Мария Рыкова");
        staffList.add("Марина Лугова");
        staffList.add("Анна Владимирова");
        staffList.add("Иван Мечников");
        staffList.add("Петр Петин");
        staffList.add("Иван Ежов");

        Map<String, Integer> nameMap = new HashMap<>();

        for (String fullName : staffList) {
            String[] fullNameArray = fullName.split(" ");
            String name = fullNameArray[0];
            if (nameMap.containsKey(name)) {
                nameMap.put(name, nameMap.get(name) + 1);
            } else {
                nameMap.put(name, 1);
            }
        }

        Map<String, String> doubleCountNameMap = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<String, Integer> entry : nameMap.entrySet()) {
            if (entry.getValue() > 1) {
                doubleCountNameMap.put(entry.getValue() + " " + entry.getKey(), entry.getKey());
            }
        }

        for (Map.Entry<String, String> entry : doubleCountNameMap.entrySet()) {
            System.out.println(entry.getValue() + ", повторяется " + nameMap.get(entry.getValue()) + " раз");
        }

    }
}

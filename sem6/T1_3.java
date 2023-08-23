package hw.sem6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class T1_3 {
    /*
Напишите метод, который заполнит массив из 1000 элементов случайными цифрами от 0 до 24.
Создайте метод, в который передайте заполненный выше массив и с помощью Set.
Вычислите процент уникальных значений в данном массиве и выведете их на печать.
Для вычисления процента используйте формулу:
% уникальных чисел = количество уникальных чисел  * 100 / общее количество чисел в массиве.
 */
    public static void main(String[] args) {
        Integer[] myArray = getArray(0, 24, 1000);
        System.out.printf("\nПроцент уникальных чисел = %s", unNumbers(myArray) + "%");

    }

    // МЕТОД ФОРМИРОВАНИЯ МАССИВА С ЗАДАННЫМИ ПАРАМЕТРАМИ
    public static Integer[] getArray(int min, int max, int size) {
        Integer[] array = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(min, max);
        }
        System.out.printf("Сформирован массив чисел: %s", Arrays.toString(array));
        return array;
    }

    // МЕТОД ОПРЕДЕЛЕНИЯ УНИКАЛЬНЫХ ЦИФР В МАССИВЕ И ИХ
    public static Double unNumbers(Integer[] myArray) {
        double unVal;
        HashSet<Integer> mySet = new HashSet<>(Arrays.asList(myArray));
        unVal = mySet.size() * 100.0 / myArray.length;
        return unVal;
    }
}


package hw.sem5;

import java.util.*;

/*1) Подсчитать количество вхождения каждого слова. Пример:
        Россия идет вперед всей планеты. Планета — это не Россия.
        toLoverCase().
        (Усложнение - игнорировать пунктуацию)*
*/

public class T1 {
    public static void main(String[] args) {
        System.out.println("Введите текст");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] words = str.split("\\s+");
        HashMap<String, Integer> wordToCount = new HashMap<>();
        for (String word : words) {
            if (word.endsWith(".") || word.endsWith(",") || word.endsWith("!") || word.endsWith("?") || word.endsWith(":") || word.endsWith(";")) {
                word = word.substring(0, word.length() - 1);
            }
            if (!word.equals("—") && !word.equals("-") && !word.equals("+") && !word.equals("=")) {
                if (!wordToCount.containsKey(word)) {
                    wordToCount.put(word, 0);
                }
                wordToCount.put(word, wordToCount.get(word) + 1);
            }
        }
        for (String word : wordToCount.keySet()) {
            System.out.println(word.toLowerCase() + " " + wordToCount.get(word));
        }
    }
}


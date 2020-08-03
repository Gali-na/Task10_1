import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.TreeSet;

/**
 * <p>Реалізуйте метод `getUniqueCharacters(String fileName)` який приймає як параметр назву файлу.
 * Для цього використовуйте TreeSet. Файл містить букви латинського алфавіту і розділові знаки.</p>
 *
 * <p>Метод повинен відсортувати всі букви по алфавіту і повернути строку з 5 різних букв без
 * розділових знаків.
 * Якщо у файлі міститься менше п'яти різних букв, то потрібно повернути їх усі.
 * Можливий випадок, коли переданого файлу не існує, в такому разі потрібно викинути помилку
 * про відсутність файлу.</p>
 *
 * <p>Приклад 1: ur-BvT?^ ra w; p
 * Результат 1: abprt</p>
 *
 * <p>Приклад 2: A _f*c a?F
 * Результат 2: acf</p>
 */
public class TreeSetCharacters {
    public String getUniqueCharacters(String fileName) throws IOException, FileNotFoundException {
        if (!Files.exists(Paths.get(fileName))) {
            throw new FileNotFoundException("FileNotFoundException should be thrown");
        }
        String readFile = "";
        List<String> lines = Files.readAllLines(Paths.get(fileName), UTF_8);

        for (String s : lines) {
            readFile = readFile + s;
        }
        String tempArryString = readFile.replaceAll("[^a-zA-Z]", "").toLowerCase();
        char[] ahhyChar = tempArryString.toCharArray();
        TreeSet<Character> nameFile = new TreeSet<>();
        for (int i = 0; i < ahhyChar.length; i++) {
            nameFile.add(ahhyChar[i]);
        }
        String rezult = "";
        int count = 5;
        for (Character c : nameFile) {
            rezult = rezult + c.toString();
            if (count == 1) {
                return rezult;
            }
            count--;
        }
        return rezult;
    }
}

package org.example.task2;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * Игровое поле 3х3 с заданными символами
 */
public class PlayingField {

    /**
     * Относительный или абсолютный путь до файла, в котором будет храниться информация
     * об игровом поле
     */
    public static final String PATH_TO_FILE = "Homework5/src/main/java/org/example/task2/field.txt";

    /**
     * Количество ячеек квадратного игрового поля
     */
    public static final int NUMBER_CELLS = 9;

    /**
     * Массив символовов, которые могут быть использованы на игровом поле
     */
    public static final char[] symbols = {' ', 'X', 'O', '•'};

    /**
     * Записать закодированную информацию о состоянии игрового поля в файл.
     *
     * @param field массив символов, соответствующий игровому полю
     */
    public void writeToFile(char[] field) {
        if (field != null && field.length == NUMBER_CELLS) {
            try (PrintWriter out = new PrintWriter(
                    new FileOutputStream(PATH_TO_FILE, false),
                    false, StandardCharsets.UTF_8)
            ) {
                String result = convertFieldToString(field);
                out.println(result);
                out.flush();
            } catch (IOException | RuntimeException e) {
                throw new RuntimeException("Не получилось записать в файл", e);
            }
        } else throw new RuntimeException("С данными полем что-то не так...");
    }

    /**
     * Считать игровое поле из файла.
     *
     * @return массив символов, соответствующий игровому полю
     */
    public char[] readFromFile() {
        try (FileReader fr = new FileReader(PATH_TO_FILE);
             BufferedReader reader = new BufferedReader(fr)) {
            String code = reader.readLine();
            return convertStringToField(code);
        } catch (IOException | RuntimeException e) {
            throw new RuntimeException("Нельзя расшифровать данные из файла", e);
        }
    }

    /**
     * Вывести игровое поле в консоль в виде квадратного поля.
     *
     * @param field массив символов, соответствующий игровому полю
     */
    public void printField(char[] field) {
        if (field == null || field.length != NUMBER_CELLS) {
            throw new RuntimeException("Нельзя распечатать поле. Неверный формат");
        }
        double sideLength = Math.sqrt(NUMBER_CELLS);
        if (sideLength % 1 != 0) {
            throw new RuntimeException("Поле не квадратное");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sideLength; i++) {
            sb.append('|');
            for (int j = 0; j < sideLength; j++) {
                sb.append(field[(int) (i * sideLength + j)]).append('|');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    /**
     * Шифрует значения в ячейках игрового поля соответствующими цифрами.
     *
     * @param field массив символов, соответствующий игровому полю
     * @return полученная строка из цифр
     */
    private String convertFieldToString(char[] field) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NUMBER_CELLS; i++) {
            if (field[i] == symbols[0]) sb.append(0);
            else if (field[i] == symbols[1]) sb.append(1);
            else if (field[i] == symbols[2]) sb.append(2);
            else if (field[i] == symbols[3]) sb.append(3);
            else throw new RuntimeException("Ошибка. Неизвестный символ '" + field[i] + '\'');
        }
        return sb.toString();
    }

    /**
     * Дешифрует строку из цифр обратно в массив символов игрового поля.
     *
     * @param code закодированная строка из цифр
     * @return массив символов, соответствующий игровому полю
     */
    private char[] convertStringToField(String code) {
        if (code == null || code.length() != NUMBER_CELLS) {
            throw new RuntimeException("Неверный формат строки. Нельзя расшифровать файл");
        }
        char[] field = new char[NUMBER_CELLS];

        for (int i = 0; i < NUMBER_CELLS; i++) {
            switch (code.charAt(i)) {
                case '0' -> field[i] = symbols[0];
                case '1' -> field[i] = symbols[1];
                case '2' -> field[i] = symbols[2];
                case '3' -> field[i] = symbols[3];
                default -> throw new RuntimeException(
                        "Ошибка. Неизвестный символ '" + code.charAt(i) + '\'');
            }
        }
        return field;
    }
}

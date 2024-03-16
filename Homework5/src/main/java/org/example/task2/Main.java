package org.example.task2;

public class Main {

    public static void main(String[] args) {
        PlayingField pf = new PlayingField();
        char[] playField =
                {
                        ' ', 'X', 'O',
                        'X', '•', 'O',
                        'O', ' ', 'X'
                };
        System.out.println("Исходное игровое поле");
        pf.printField(playField);

        pf.writeToFile(playField);

        System.out.println("--------------");

        playField = pf.readFromFile();

        System.out.println("Полученное из файла игровое поле");
        pf.printField(playField);
    }


}

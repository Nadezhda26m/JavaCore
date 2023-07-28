package org.example.hw.seminar1.view;

import java.util.Scanner;

public class MyView {
    static Scanner scan = new Scanner(System.in);

    public static String getTitle() {
        System.out.print("Введите заголовок: ");
        String title = scan.nextLine();
        if (title.length() == 0 || title.length() > 25 || title.charAt(0) == ' ') {
            System.out.println("Повторите ввод");
            return getTitle();
        }
        return title;
    }

    public static String getText() {
        System.out.print("Введите текст: ");
        String title = scan.nextLine();
        if (title.length() < 4) {
            System.out.println("Требуется не менее 4 символов. Повторите ввод");
            return getText();
        }
        return title;
    }
}

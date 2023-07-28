package org.example.hw.seminar1.prod;

import org.example.hw.seminar1.core.Notepad;
import org.example.hw.seminar1.view.MyView;

public class Main {
    public static void main(String[] args) {
        Notepad notepad = new Notepad();
        notepad.addNote(MyView.getTitle(), MyView.getText());
        notepad.addNote(MyView.getTitle(), MyView.getText());
        notepad.addNote(MyView.getTitle(), MyView.getText());
        System.out.println("Notepad");
        System.out.println(notepad);
    }
}

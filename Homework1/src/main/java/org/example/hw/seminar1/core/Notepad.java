package org.example.hw.seminar1.core;

import java.util.ArrayList;

public class Notepad {
    protected ArrayList<Note> notepad;
    protected int currentIndex;

    public Notepad() {
        this.notepad = new ArrayList<>();
        this.currentIndex = 1;
    }

    public void addNote(String title, String text) {
        Note note = new Note(title, text);
        note.index = currentIndex++;
        notepad.add(note);
    }

    public int getSize() {
        return notepad.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Note note : notepad) {
            sb.append(note.toString()).append("\n");
        }
        return sb.toString();
    }
}

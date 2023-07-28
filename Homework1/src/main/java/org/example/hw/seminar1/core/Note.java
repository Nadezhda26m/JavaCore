package org.example.hw.seminar1.core;

import java.time.LocalDate;

public class Note {
    protected String title;
    protected String text;
    protected final LocalDate CREATE_DATE;
    protected int index;

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
        this.CREATE_DATE = LocalDate.now();
    }

    @Override
    public String toString() {
        return index + ". " + title + " "
                + CREATE_DATE + "\n>> " + text;
    }
}

package ru.jcore.exceptions;

public class ProductException extends Exception {
    public ProductException() {
        super("Товар не найден");
    }

    public ProductException(String message) {
        super(message);
    }
}

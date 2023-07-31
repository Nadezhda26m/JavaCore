package ru.core.task2;

// Написать метод «Шифр Цезаря», с булевым параметром зашифрования
// и расшифрования и числовым ключом;

public class Main02 {
    public static void main(String[] args) {
        // String string = "абвгдежзиклмн";
        String string = "здесьдолженбытьtext";
        System.out.println(string);
        String yes = ceasar(string, 4, true);
        System.out.println(yes); // лийхѐитпкйсеяцѐxi|x
        System.out.println(ceasar(yes, 4, false));
    }

    public static String ceasar(String in, int key, boolean encrypt) {
        if (in == null || in.isEmpty())
            return null;
        final int len = in.length();
        char[] out = new char[len];
        for (int i = 0; i < len; i++) {
            out[i] = (char) (in.charAt(i) + ((encrypt) ? key : -key));
        }
        return new String(out);
    }
}

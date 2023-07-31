package ru.core.task2;

// Написать метод «Шифр Цезаря», с булевым параметром зашифрования
// и расшифрования и числовым ключом;

public class Main02 {
    public static void main(String[] args) {
        String alphabetLowCase = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        String string = "здеСь.должен/быТь теКст";
        System.out.println(string);
        String yes = ceasar(string, 4, true);
        System.out.println(yes); // лийХѐ2итпкйс3еяЦѐ$цйОхц
        System.out.println(ceasar(yes, 4, false));
        System.out.println(shiftCipher(string, alphabetLowCase, 3, true));
        // кжзФя.жсойзр/дюХя хзНфх
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

    public static String shiftCipher(String original, String alphabet,
                                     int countShift, boolean encode) {
        char[] characters = new char[alphabet.length()];
        alphabet.getChars(0, alphabet.length(), characters, 0);
        char[] result = new char[original.length()];
        String downOriginal = original.toLowerCase();
        char newChar;
        boolean isLetter;
        for (int i = 0; i < result.length; i++) {
            isLetter = false;
            for (int j = 0; j < characters.length; j++) {
                if (downOriginal.charAt(i) == characters[j]) {
                    // encode = true
                    newChar = characters[(j + countShift) % characters.length];
                    if (original.charAt(i) != downOriginal.charAt(i)) {
                        result[i] = Character.toUpperCase(newChar);
                    } else {
                        result[i] = newChar;
                    }
                    isLetter = true;
                }
            }
            if (!isLetter) {
                result[i] = original.charAt(i);
            }
        }
        return new String(result);
    }
}

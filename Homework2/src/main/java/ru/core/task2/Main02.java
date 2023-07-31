package ru.core.task2;

// Написать метод «Шифр Цезаря», с булевым параметром зашифрования
// и расшифрования и числовым ключом;

public class Main02 {
    public static void main(String[] args) {
        String alphabetLowCase = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        int countShift = 4;
        String string = "здеСь.должен/быТь теКст";
        System.out.println("Оригинал:       " + string);
        String cipherStr = ceasar(string, countShift, true);
        System.out.println("Unicode shift:  " + cipherStr);
        // здеСь.должен/быТь теКст
        // лийХѐ2итпкйс3еяЦѐ$цйОхц
        System.out.println("                "
                + ceasar(cipherStr, countShift, false));
        String cipherStr2 = shiftCipher(string, alphabetLowCase, countShift, true);
        System.out.println("Alphabet shift: " + cipherStr2);
        // здеСь.должен/быТь теКст
        // лзиХа.зтпкис/еяЦа циОхц
        System.out.println("                "
                + shiftCipher(cipherStr2, alphabetLowCase, countShift, false));
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
        char[] chars = new char[alphabet.length()];
        alphabet.getChars(0, alphabet.length(), chars, 0);
        char[] result = new char[original.length()];
        String downOriginal = original.toLowerCase();
        char newChar;
        boolean isLetter;
        for (int i = 0; i < result.length; i++) {
            isLetter = false;
            for (int j = 0; j < chars.length; j++) {
                if (downOriginal.charAt(i) == chars[j]) {
                    newChar = chars[Math.abs((j + ((encode) ? countShift : -countShift)))
                            % chars.length];
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

package ru.core.task2;

// Написать метод «Шифр Цезаря», с булевым параметром зашифрования
// и расшифрования и числовым ключом;

public class Main02 {
    public static void main(String[] args) {
        try {
            int countShift = 4;
            String string = "здеСь.должен/быТь теКст";
            System.out.println("Original:       " + string);

            String cipherStr = ceasar(string, countShift, true);
            System.out.println("Unicode shift:  " + cipherStr);
            // здеСь.должен/быТь теКст
            // лийХѐ2итпкйс3еяЦѐ$цйОхц
            System.out.println("Decode:         "
                    + ceasar(cipherStr, countShift, false));

            String alphabetLowCase = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
            String cipherStr2 = shiftCipher(string, alphabetLowCase, countShift, true);
            System.out.println("Alphabet shift: " + cipherStr2);
            // здеСь.должен/быТь теКст
            // лзиХа.зтпкис/еяЦа циОхц
            System.out.println("Decode:         "
                    + shiftCipher(cipherStr2, alphabetLowCase, countShift, false));
        } catch (RuntimeException e) {
            System.out.println("Exception: " + e.getMessage());;
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        checkParameters(original, alphabet, countShift);
        char[] result = new char[original.length()];
        String downOriginal = original.toLowerCase();
        char newChar;
        int index;
        for (int i = 0; i < result.length; i++) {
            index = alphabet.indexOf(downOriginal.charAt(i));
            if (index == -1) {
                result[i] = original.charAt(i);
            } else {
                newChar = alphabet.charAt((alphabet.length() +
                        (index + (encode ? countShift : -countShift)))
                        % alphabet.length());
                if (original.charAt(i) != downOriginal.charAt(i)) {
                    result[i] = Character.toUpperCase(newChar);
                } else result[i] = newChar;
            }
        }
        return new String(result);
    }

    private static void checkParameters(String original, String alphabet, int countShift) {
        if (original == null || alphabet == null
                || original.isEmpty() || alphabet.isEmpty())
            throw new RuntimeException("Некорректные данные");
        if (!(alphabet.matches("[а-яё]+") || alphabet.matches("[a-z]+")))
            throw new RuntimeException("Указан неверный формат алфавита");
        if (countShift < 0)
            throw new RuntimeException("Некорректный ключ");
        // if (...) { ... }
    }
}

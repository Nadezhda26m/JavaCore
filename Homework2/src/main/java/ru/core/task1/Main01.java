package ru.core.task1;

/*
Написать метод, осуществляющий сортировку одномерного
массива подсчётом. Важное ограничение состоит в том, что для этой
сортировки диапазон значений (max - min) исходного массива должен находиться в
разумных пределах, например, не более 1000. */

// [ 4, 4, 2, 6, 4, 6, 8, 4 ] - исходный массив
//   min                     max
//    v                       v
//    2,  3,  4,  5,  6,  7,  8 - числа от min до max по порядку
// [  0,  1,  2,  3,  4,  5,  6 ] - индексы
// [ x1,  0, x4,  0, x2,  0, x1 ] - количество повторений

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

public class Main01 {
    public static void main(String[] args) {
        try {
            // int[] array = null;
            // int[] array = createAndFillArray(1, -99, 99);
            // int[] array = createAndFillArray(20, 1, 1);
            int[] array = createAndFillArray(100, -99, 99);
            System.out.println("Исходный массив: " + Arrays.toString(array));
            System.out.println("TreeMap:         " + Arrays.toString(countSort2(array)));
            System.out.println("Исходный массив: " + Arrays.toString(array));
            countSort1(array);
            System.out.println("CountingArray:   " + Arrays.toString(array));
        } catch (RuntimeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }

    public static int[] createAndFillArray(int size, int minValue, int maxValue) {
        if (size < 0)
            throw new RuntimeException("Неверный размер массива");
        if (minValue > maxValue) {
            int temp = minValue;
            minValue = maxValue;
            maxValue = temp;
        }
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(minValue, maxValue + 1);
        }
        return array;
    }

    public static void countSort1(int[] arr) {
        if (arr == null)
            throw new NullPointerException("Неинициализированный массив");
        if (arr.length < 2)
            return;
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) maxValue = arr[i];
            if (arr[i] < minValue) minValue = arr[i];
        }
        if (minValue == maxValue) // в массиве одинаковые числа
            return;
        int[] countingArray = new int[Math.abs(maxValue - minValue) + 1];
        for (int i = 0; i < arr.length; i++) {
            countingArray[arr[i] - minValue]++;
        }
        int index = 0;
        for (int i = 0; i < countingArray.length; i++) {
            for (int j = 0; j < countingArray[i]; j++) {
                arr[index++] = i + minValue;
            }
        }
    }

    // С использованием TreeMap
    public static int[] countSort2(int[] arr) {
        if (arr == null)
            throw new NullPointerException("Неинициализированный массив");
        int[] sortArray = new int[arr.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int i = 0;
        for (Integer key : map.keySet()) {
            for (int j = 0; j < map.get(key); j++) {
                sortArray[i++] = key;
            }
        }
        return sortArray;
    }
}

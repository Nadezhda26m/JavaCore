package ru.core.task3;

/*
Написать метод, принимающий на вход массив чисел и параметр n.
Метод должен осуществить циклический (последний элемент при сдвиге
становится первым) сдвиг всех элементов массива на n позиций; */

import java.util.Arrays;

public class Main03 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(circularShift(arr, 12)));
    }

    public static int[] circularShift(int[] array, int countShift) {
        if (array == null || array.length < 2)
            return array;
        int[] result = new int[array.length];
        countShift = array.length - countShift % array.length;
        int index = 0;
        for (int i = countShift; i < array.length; i++) {
            result[index++] = array[i];
        }
        for (int i = 0; i < countShift; i++) {
            result[index++] = array[i];
        }
        return result;
    }
}

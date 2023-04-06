// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка. Collections.max()

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class homework2 {
    public static void main(String[] args) {
        int arrLength = createNumber("Введите колличество элементов в массиве: ");
        int maxValue = createNumber("Введите максимальное значение элемента массива: ");

        List<Integer> mainList = new ArrayList<>();
        mainList = createArrList(arrLength, maxValue);

        findMinValue(mainList);
        findMaxValue(mainList);
        findAverageValue(mainList);
    }

    public static Integer createNumber(String frase) {
        Scanner iScan = new Scanner(System.in);
        System.out.printf("\n%s", frase);
        int num = iScan.nextInt();
        return num;
    }

    public static List<Integer> createArrList(int length, int value) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            list.add(random.nextInt(value));
        }
        System.out.printf("\nСгенерирован массив элементов: ").print(list);

        return list;
    }

    public static void findMinValue(List<Integer> list) {
        System.out.printf("\n\nМинимальное значение элемента массива: ").print(Collections.min(list));
    }

    public static void findMaxValue(List<Integer> list) {
        System.out.printf("\n\nМинимальное значение элемента массива: ").print(Collections.max(list));
    }

    public static void findAverageValue(List<Integer> list) {
        int sum = 0;
        double total;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        total = (double)sum/list.size();
        System.out.printf("\n\nСреднее арифметическое значение элемента массива: ").print(total);
    }
}
// Пусть дан произвольный список целых чисел, удалить из него четные числа

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class homework1 {
    public static void main(String[] args) {
        int arrLength = createNumber("Введите колличество элементов в массиве: ");
        int maxValue = createNumber("Введите максимальное значение элемента массива: ");

        List<Integer> mainList = new ArrayList<>();
        mainList = createArrList(arrLength, maxValue);

        chengeArrList(mainList);
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

    public static void chengeArrList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
        System.out.printf("\n\nИтоговый массив элементов: ").print(list);
    }
}
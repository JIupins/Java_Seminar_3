// Реализовать алгоритм сортировки слиянием

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class homework3 {
    public static void main(String args[]) {
        int arrLength = createNumber("Введите колличество элементов в массиве: ");
        int maxValue = createNumber("Введите максимальное значение элемента массива: ");

        mergeSort(createArr(arrLength, maxValue));
    }

    public static Integer createNumber(String frase) {
        Scanner iScan = new Scanner(System.in);
        System.out.printf("\n%s", frase);
        int num = iScan.nextInt();
        return num;
    }

    public static int[] createArr(int length, int value) {
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(value);
        }
        System.out.printf("\nСгенерирован массив элементов: ").print(Arrays.toString(arr));
        return arr;
    }

    public static void mergeSort(int[] sortArr) {
        int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] buffer2 = new int[sortArr.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, sortArr.length);
        System.out.printf("\n\nОтсортирован массив элементов: ").print(Arrays.toString(result));
    }

    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++]
                    : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}
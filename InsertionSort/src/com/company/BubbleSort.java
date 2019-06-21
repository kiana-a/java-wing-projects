package com.company;

/**
 * Created by kiana on 3/11/18.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] input = {100, 77, 3, 55, 455, 2};
        bubble_sort(input);
    }

    private static void bubble_sort(int[] array) {
        int n = array.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (array[i] > array[k]) {
                    swapNumbers(i, k, array);
                }
            }
            printNumbers(array);
        }
    }

    private static void swapNumbers(int i, int j, int[] array) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void printNumbers(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ",");
//            System.out.println(" helllllllll o");
        }
        System.out.println("\n");
    }

    // CAUTTION : ENTER E EZAFE DARE CHERA ?!
}

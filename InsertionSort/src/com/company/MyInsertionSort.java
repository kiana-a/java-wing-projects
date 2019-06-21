package com.company;

/**
 * Created by kiana on 3/11/18.
 */
public class MyInsertionSort {

    public static void main(String[] args) {
        int[] input = {4,2,6,77,1000,234,24,67};
        insertionSort(input);
    }


    private static void printNumbers(int[] input) {

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.println("\n");
    }


    private static void insertionSort(int[] array) {
        int n = array.length;
        for(int j = 1 ; j < n ; j++){
            int key = array[j];
            int i = j-1;
            while ((i > -1) && (array[i] > key )){
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = key;
            printNumbers(array);
        }
    }



}

package com.company;

/**
 * Created by kiana on 3/11/18.
 */
public class MyDuplicatesElements {

    public static int[] removeDuplicates (int[] input){
        int j = 0;
        int i = 0;
        if(input.length < 2){
            return input;
        }
        while (i < input.length){
            if (input[i] == input[j]){
                i++;
            }else {
                input[j++] = input[i++];
            }
        }
        int[] output = new int[j+1];
        for (int k = 0 ; k < output.length; k++){
            output[k] = input[k];
        }
        return output;
    }

    public static void main(String[] args) {
        int[] input1 = {2,3,6,6,6,12};
        int[] output = removeDuplicates(input1);
        for (int i:output){
            System.out.println(i + " ");

        }
    }

}

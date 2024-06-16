package com.main.dsa.sorting;

public class InsertionSort {

    int[] input = {9,4,2,1,1,4,5,6,2,4,0};

    /*
    * [Sorted Array][Unsorted Array]
    * pick element and keep swapping inside sorted array until it is at correct location.
    * [][9,4,2,1,1,4,5,6,2,4,0]
    * [9][4,2,1,1,4,5,6,2,4,0]
    * [4,9][2,1,1,4,5,6,2,4,0]
    * [2,4,9][1,1,4,5,6,2,4,0]
    * [1,2,4,9][1,4,5,6,2,4,0]
    * [1,1,2,4,9][4,5,6,2,4,0]
    * ... and so on...
     */
    public int[] sortArray(){
        for(int i=0;i<input.length;i++){
            for(int j=1;j<input.length;j++){
                while(input[j-1]>input[j]){
                    System.out.println("swapping "+input[j-1]+" and "+input[j]);
                    int temp=input[j-1];
                    input[j-1]=input[j];
                    input[j]=temp;
                }
            }
        }
        return input;
    }

}

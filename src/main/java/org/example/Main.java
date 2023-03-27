package org.example;

public class Main {
    public static void main(String[] args) {
        Algorithms alg = new Algorithms();
        int[] arr = alg.generateRandomArray(1, 10, 10);
        alg.printArray(arr);
        //alg.insertionSort(arr);
        //alg.heapSort(arr);
        alg.quickSort(arr, 0, arr.length - 1);




    }
}
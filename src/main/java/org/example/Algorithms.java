package org.example;

import java.util.Random;

public class Algorithms {

    public Algorithms() {

    }
    public void insertionSort(int[] arr) {
        /*
        This implementation uses the standard algorithm for insertion sort, where the elements of the array are shifted
         to make room for the key element to be inserted in its proper place. The outer loop iterates through each element of the
         array, and the inner loop iterates through the sorted portion of the array to find the correct position for the key element.
         Once the correct position is found, the key element is inserted by shifting the elements to the right.
         */
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
            System.out.println("-----------------------------------------------------");
            visualizeArray(arr, 200);
        }
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            System.out.println("-----------------------------------------------------");
            visualizeArray(arr, 200);
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public int partition(int[] arr, int left, int right) {
        int pivotValue = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivotValue) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
//        System.out.println("-----------------------------------------------------");
//        visualizeArray(arr, 200);
        return i + 1;

    }


    public void heapSort(int[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        System.out.println("-----------------------------------------------------");
        visualizeArray(arr, 200);
        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
            System.out.println("-----------------------------------------------------");
            visualizeArray(arr, 200);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }


    public static int[] generateRandomArray(int min, int max, int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt((max - min) + 1) + min;
        }
        return arr;
    }

    public static void visualizeArray(int[] arr, int time) {
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            System.out.print(element + "|");
            for (int j = 0; j < element; j++) {
                System.out.print("*");
            }
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }





}

package application;

import sortings.ArraySorting;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Integer[] myArray;
        ArraySorting arraySorting = new ArraySorting();
        myArray = arraySorting.generateArray(5);
        arraySorting.printArray(myArray);

        Scanner in = new Scanner(System.in);
        int input = -1;
        do {
            System.out.println("Пузырьковая сортировка -1, "
                    + "сортировка выбором -2, "
                    + "сортировка вставкой -3, "
                    + "выход - 0");

            input = in.nextInt();
            switch (input) {
                case 1: {
                    arraySorting.bubbleSort(myArray);
                    arraySorting.printArray(myArray);
                }
                break;
                case 2: {
                    arraySorting.selectionSort(myArray);
                    arraySorting.printArray(myArray);
                }

                break;
                case 3: {
                    arraySorting.insertionSort(myArray);
                    arraySorting.printArray(myArray);
                }
                break;
            }
        } while (input != 0);
    }
}

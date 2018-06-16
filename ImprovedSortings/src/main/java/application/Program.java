package application;

import algorithms.ImprovedSort;

public class Program {
    public static void main(String[] args) {

        Integer [] someArray;
        ImprovedSort improvedSort= new ImprovedSort();
        someArray= improvedSort.generateArray(6);
        improvedSort.printArray(someArray);
        int nElems= someArray.length;

        Long start= System.nanoTime();

//        improvedSort.shellSort(someArray);
//        improvedSort.quickSort(someArray, 0, nElems-1);
        improvedSort.heapSort(someArray);

        Long end= System.nanoTime();
        Long interval= (end-start);

        System.out.println("Время "+ interval+ " нс");
        improvedSort.printArray(someArray);
    }
}

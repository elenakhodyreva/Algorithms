package algorithms;

import java.util.Random;

public class ImprovedSort {
    private Integer[] myArray;
    Random random = new Random();

    public Integer[] generateArray(Integer size) {
        myArray = new Integer[size];
        for (int i = 0; i < myArray.length; i++)
            myArray[i] = random.nextInt(100) + 1;
        return myArray;
    }

    public void printArray(Integer[] arr) {
        for (Integer i : arr)
            System.out.print(" " + i);
        System.out.println();
    }

    public void shellSort(Integer[] arr) {

        int n = arr.length;


        int i = 0;
        int items = 1;
        int arrSize = 0;
        Integer[] itemsArray = new Integer[100];

        //как в методичке
        while (i < arr.length && items < arr.length) {
            itemsArray[i] = items;
            arrSize++;
            items = 2 * items + 1;
            i++;
        }

        for (int j = 0; j < arrSize; j++)
            System.out.print("массив шагов " + itemsArray[j]);
        System.out.println();

        //по формуле log 2 x= log 10 x/ log 10 2
        Double x = Math.log10(arr.length) / (Math.log10(2));
        int stepCount = (int) (Math.round(x)) - 1;
        System.out.println("Количество шагов " + stepCount);


        // не как в методичке получается быстрее
        int temp;
        int h = 1;
        //интервальная последовательность Кнута (Лафоре стр 307)
        while (h <= n / 3)
            h = h * 3 + 1;

        System.out.println("max step " + h);

        while (h > 0) {

            for (int out = h; out < n; out++) {
                temp = arr[out];
                int in;
                for (in = out; in > h - 1 && arr[in - h] >= temp; in -= h) {
                    arr[in] = arr[in - h];
                }
                arr[in] = temp;
            }
            h = (h - 1) / 3;
        }

        //раз два шага значит индексы массива будут начинаться на 1 меньше то есть 1 и 0
        // считаем в обратном порядке
//        for(int st= stepCount-1; st>=0; st--){
//
//            int h= itemsArray[st];
//            for (int out = h; out < n; out++) {
//                temp = arr[out];
//                int in;
//                for (in = out; in > h - 1 && arr[in - h] >= temp; in -= h) {
//                    arr[in] = arr[in - h];
//                }
//                arr[in] = temp;
//            }
//        }
    }

    public void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(Integer[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public void heapSort(Integer[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    private void heapify(Integer[] arr, int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}

package sortings;

import java.util.Random;

public class ArraySorting {

    private Integer[] someArray;
    Random random = new Random();

    public ArraySorting() {
    }

    public Integer[] generateArray(Integer size) {
        someArray = new Integer[size];
        for (int i = 0; i < someArray.length; i++) {
            someArray[i] = random.nextInt(100) + 1;
        }
        return someArray;
    }

    public void printArray(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("" + arr[i] + " ");
        }
        System.out.println("\n");
    }

    public void bubbleSort(Integer[] arr) {

        for (int out = arr.length - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {

                if (arr[in] > arr[in + 1]) {
//                    int temp = arr[in];
//                    arr[in] = arr[in + 1];
//                    arr[in + 1] = temp;
                    swap(arr, in, in + 1);
                }
            }
        }
    }

    public void selectionSort(Integer[] arr) {
        int out, in, min;
        for (out = 0; out < arr.length - 1; out++) // Внешний цикл
        {
            min = out; // Минимум
            for (in = out + 1; in < arr.length - 1; in++) {
                if (arr[in] < arr[min]) {
                    // Если значение min больше,
                    min = in; // значит, найден новый минимум
                }
                //swap
                int temp = arr[out];
                arr[out] = arr[min];
                arr[min] = temp;
            }

        }
    }

    public void insertionSort(Integer[] arr) {
        int in, out;
        for (out = 1; out < arr.length; out++) // out - разделительный маркер
        {
            Integer temp = arr[out]; // Скопировать помеченный элемент
            in = out; // Начать перемещения с out
            while (in > 0 && arr[in - 1] >= temp) // Пока не найден меньший элемент
            {
                arr[in] = arr[in - 1]; // Сдвинуть элемент вправо
                --in; // Перейти на одну позицию влево
            }
            arr[in] = temp; // Вставить помеченный элемент
        }
    }

    private void swap(Integer[] arr, Integer one, Integer two) {
        Integer temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}

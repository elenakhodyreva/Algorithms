package services;

import java.util.Random;

public class MyStack<E> {
    private E[] stackArray;
    private Integer top; // Вершина стека
    Random random = new Random();

    public MyStack(Integer s) // Конструктор
    {
        //напрямую создать типа E[] нельзя так как для дженериков массив создается во время компиляции
        stackArray = (E[]) new Object[s]; // Создание массива
        top = -1; // Пока нет ни одного элемента
    }

    //добавление элемента в вершину стека
    public void push(E j) // Размещение элемента на вершине стека
    {
//            stackArray[++top] = j;

        //динамически
        //если top указывает на последний элемент массива
        if (top == (stackArray.length - 1)) {

            //создаем новый массив в два раза больше прежнего
            E temp[] = (E[]) new Object[stackArray.length * 2];
            int i;
            for (i = 0; i < stackArray.length; i++) {
                // данные из прежнего копируем в новый
                temp[i] = stackArray[i];
            }
            // присваиваем прежнему массиву ссылку на новый
            stackArray = temp;
            stackArray[++top] = j;
        } else
            stackArray[++top] = j;
    }

    //удаление элемента из вершины стека
    public E pop() // Извлечение элемента с вершины стека
    {
        return stackArray[top--];
    }

    //	вывод текущего состояния стека на экран
    public E peek() // Чтение элемента с вершины стека
    {
        return stackArray[top];
    }

    //проверку пустоты стека
    public Boolean isEmpty() // True, если стек пуст
    {
        return (top == -1);
    }

    //проверку заполненности стекового массива
    public Boolean isFull() // True, если стек полон
    {
        return (top == (stackArray.length - 1));
    }

    public void pushSomeValues(Integer count) {

        for (int i = 0; i < count; i++) {

            Integer x = random.nextInt(100) + 1;
            System.out.println("x= " + x);
            this.push((E)x);
        }
    }
}

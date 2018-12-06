package application;

import services.MyStack;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        MyStack<Integer> nStack = new MyStack<Integer>(5);
        Scanner in = new Scanner(System.in);
        Scanner inDigit = new Scanner(System.in);
        int input = -1;
        int digit;

        do {
            System.out.println("Добавить число -1 "
                    + "просмотр вершины стека -2 "
                    + "извлечь элемент -3 "
                    + "добавить несколько значений -4 "
                    + "выход - 0\n");

            input = in.nextInt();
            switch (input) {
                case 1: {
                    //добавить
                    // проверить на заполненность для статического стека
                    if (!nStack.isFull()) {

                        System.out.println("введите число для добавления");
                        digit = inDigit.nextInt();
                        nStack.push(digit);
                    } else
                        System.out.println("стек заполнен");
                }
                break;
                case 2: {
                    //вершина стека
                    if (!nStack.isEmpty())
                        System.out.println("вершина " + nStack.peek());
                    else
                        System.out.println("стек пуст");
                }
                break;
                case 3: {
                    //извлечь
                    if (!nStack.isEmpty())
                        System.out.println("извлекли элемент " + nStack.pop());
                    else
                        System.out.println("стек пуст");
                }
                break;
                case 4: {
                    //только для динамического выделения памяти
                    System.out.println("Введите количество значений");
                    digit = inDigit.nextInt();

                    nStack.pushSomeValues(digit);

                }
                break;
            }

        } while (input != 0);
    }
}

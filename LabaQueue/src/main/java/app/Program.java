package app;

import services.MyQueue;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        MyQueue theMyQueue = new MyQueue(5);

        Scanner in = new Scanner(System.in);
        Scanner inDigit= new Scanner(System.in);
        int input=-1;
        int digit;

        do {
            System.out.println("Добавить число -1 "
                    + "просмотр вершины очереди -2 "
                    + "извлечь элемент -3 "
                    + "выход - 0");

            input=in.nextInt();
            switch(input)
            {
                case 1:
                {
//                    if(!theMyQueue.isFull()){
//                      динамически
                    System.out.println("Введите число для добавления");
                    digit= inDigit.nextInt();
                    System.out.println("size = "+ theMyQueue.size());
                    theMyQueue.insert(digit);
//                    }
//                    else
//                        System.out.println("очередь заполнена");

                }
                break;
                case 2:
                {
                    if(!theMyQueue.isEmpty())
                        System.out.println("вершина "+ theMyQueue.peekFront());
                    else
                        System.out.println("очередь пуста");
                }

                break;
                case 3:
                {
                    if(!theMyQueue.isEmpty())
                        System.out.println("извлекли элемент "+ theMyQueue.remove());
                    else
                        System.out.println("очередь пуста");
                }
                break;

            }
        } while (input!=0);
    }
}

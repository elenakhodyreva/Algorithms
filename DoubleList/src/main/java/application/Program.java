package application;

import structures.DoubleLinkedList;
import structures.ListOfLists;

public class Program {
    public static void main(String[] args) {

        DoubleLinkedList<Integer> doubleLinkedList= new DoubleLinkedList<>();
        //добавить элемент в начало
        doubleLinkedList.insertFirst(5 );
        doubleLinkedList.insertFirst(20);
        doubleLinkedList.insertFirst(30);

        //вывод элементов в прямом и обратном направлении
        doubleLinkedList.displayForward();
        doubleLinkedList.displayBackward();

        //удалить заданный элемент
        doubleLinkedList.deleteKey(20);
        doubleLinkedList.displayForward();

        //добавить элемент перед и после заданного
        doubleLinkedList.insertAfter(30,70);
        doubleLinkedList.insertBefore(5,90);
        doubleLinkedList.displayForward();

        //поиск заданного элемента в прямом и обратном направлениях
        Integer elem=30;
        if(doubleLinkedList.findForward(elem))
            System.out.println("в прямом направлении элемент "+elem+" найден");
        if(doubleLinkedList.findBackward(elem))
            System.out.println("в обратном направлении элемент "+elem+" найден");

        Integer notFoundElem=55;
        if(!doubleLinkedList.findForward(notFoundElem))
            System.out.println("элемент "+notFoundElem+" не найден");

        //задание 3

        System.out.println("*************   задание 3 ***************");
        DoubleLinkedList<Integer> list1= new DoubleLinkedList<>();
        list1.insertFirst(1);
        list1.insertFirst(2);
        list1.insertFirst(3);

        DoubleLinkedList<Integer> list2= new DoubleLinkedList<>();
        list1.insertFirst(4);
        list1.insertFirst(5);
        list1.insertFirst(6);

        ListOfLists container= new ListOfLists();
        container.insertFirst(list1);
        container.insertFirst(list2);

        container.displayForward();

        int listElem=5;
        if(container.findForward(listElem))
            System.out.println("найден");
        else
            System.out.println("не найден");


        DoubleLinkedList<Integer> deletedList= new DoubleLinkedList<>();
        deletedList.insertFirst(4);
        deletedList.insertFirst(5);
        deletedList.insertFirst(6);

        if(container.findElem(deletedList))
            System.out.println("список найден");

        container.deleteItem(deletedList);
        container.displayForward();
    }
}

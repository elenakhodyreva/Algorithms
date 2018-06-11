package app;

import models.Link;
import structures.LinkList;

public class Program {
    public static void main(String[] args) {
        LinkList<Integer> theList = new LinkList(); // Создание нового списка

        //проверить если список пуст
        //theList.insertAfter(50, 1);

        theList.insertFirst(10); // Вставка четырех элементов
        theList.insertFirst(20);
        theList.insertFirst(30);
        theList.insertFirst(40);
        theList.insertFirst(50);
        theList.displayList(); // Вывод содержимого списка


        theList.insertAfter(7,30);
        theList.displayList(); // Вывод содержимого списка

//        while( !theList.isEmpty() ) // Пока остаются элементы,
//        {
//            Link aLink = theList.deleteFirst(); // Удаление элемента
//            System.out.print("Deleted "); // Вывод удаленного элемента
//            aLink.displayLink();
//            System.out.println("");
//        }
//        theList.displayList(); // Вывод содержимого списка

        System.out.println();
        System.out.println("******** Метод contains **********");

        Integer elem=30;
        if(theList.contains(elem))
            System.out.println("список содержит элемент "+ elem);
        else
            System.out.println("список не содержит элемент "+ elem);
    }
}

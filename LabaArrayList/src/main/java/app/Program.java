package app;

import structures.MyArrayList;

public class Program {
    public static void main(String[] args) {

        MyArrayList<Integer> myList= new MyArrayList();

        myList.add(20);
        myList.add(30);
        myList.add(40);
        myList.add(50);
        myList.add(60);

        //проход по списку с выводом на экран информационных частей элементов
        myList.printArrayList();
        System.out.println(" количество элементов " +myList.size());

        System.out.println("********************");
        System.out.println("");

        //добавление нового элемента после заданного и перед заданным
        // со сдвигом (при необходимости) хвостовой части вправо для освобождения ячейки массива

        //добавить до индекса
        myList.insertBefore(70, 2);
        myList.printArrayList();
        System.out.println(" количество элементов " +myList.size());

        //добавить после индекса
        myList.insertAfter(110, 3);
        myList.printArrayList();
        System.out.println(" количество элементов " +myList.size());

        //удаление заданного элемента со сдвигом (при необходимости) хвостовой части влево для
        // заполнения образовавшейся пустой ячейки
        //удалить с определенным индексом
        myList.remove(0);
        myList.printArrayList();
        System.out.println(" количество элементов " +myList.size());

        // поиск элемента с заданной информационной частью, когда нет
        int elem=55;
        if(myList.contains(elem)!=-1)
            System.out.println("");
        else
            System.out.println("элемента "+ elem+"  нет ");

        // поиск элемента с заданной информационной частью, когда есть
        elem=70;
        if(myList.contains(elem)!=-1)
            System.out.println("индекс элемента "+elem+" равен "+ myList.contains(70));
        else
            System.out.println("такого элемента нет ");
    }
}

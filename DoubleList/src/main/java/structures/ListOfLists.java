package structures;

import com.sun.org.apache.xpath.internal.operations.Bool;
import models.Link;

public class ListOfLists{

    private DoubleLinkedList first;
    private DoubleLinkedList last;

    public ListOfLists() {
        this.first = null;
        this.last = null;
    }


    public boolean isEmpty()
    { return first==null; }

    //добавление нового элемента в связанный список
    public void insertFirst(DoubleLinkedList<Integer> dd) // Вставка элемента в начало списка
    {
        DoubleLinkedList<Integer> newLink = new DoubleLinkedList();// Создание нового элемента
        newLink= dd;
        if( isEmpty() ) // Если список не содержит элементов,
            last = newLink; // newLink <-- last
        else
            first.previous = newLink; // newLink <-- старое значение first
        newLink.next = first; // newLink --> старое значение first
        first = newLink; // first --> newLink
    }

    //удаление элемента из базового массива
    public Boolean findElem(DoubleLinkedList<Integer> elem) // Удаление элемента с заданным ключом
    {
        DoubleLinkedList current = first.next; // От начала списка
        Link<Integer> currentLink = elem.getFirst();

        Boolean isEquals = false;

        while (current != null) {
            while (currentLink != null) {
                if (current.findForward(currentLink.dData)) {
                    isEquals = true;
                }
                else {
                    isEquals= false;
                }
                currentLink = currentLink.next;
            }
            current = current.next;
        }

        if(isEquals)
            return true;
        else
            return false;
    }


    public void deleteItem(DoubleLinkedList<Integer> elem){

        if(findElem(elem)){
            DoubleLinkedList current = first.next; // От начала списка
            Link<Integer> currentLink = elem.getFirst(); //берем первый элемент от списка

            while (current != null) {
                while (currentLink != null) {

                    current.deleteKey(currentLink.dData);
                    currentLink = currentLink.next;
                }
                current = current.next;
            }


            System.out.println("элемент удален");
        }
        else{
            System.out.println("такого списка нет");
        }
    }

    //полный проход по всей структуре
    public void displayForward()
    {
        DoubleLinkedList current = first;
        while(current != null)
        {
            current.displayForward();
            current = current.next;
        }
        System.out.println("");
    }

    //поиск заданного элемента
    public boolean findForward(Integer key){
        DoubleLinkedList current = first.next; // От начала списка

        while (!current.findForward(key)){
            current = current.next; // Переход к следующему элементу
            if(current == null){
                return false;
            }
        }
        return true;
    }
}

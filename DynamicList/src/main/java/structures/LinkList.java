package structures;

import models.Link;

public class LinkList<T> {
    private Link first; // Ссылка на первый элемент списка

    public LinkList() // Конструктор
    {
        first = null; // Список пока не содержит элементов
    }

    public boolean isEmpty() // true, если список пуст
    {
        return (first==null);
    }

    // Вставка элемента в начало списка
    public void insertFirst(T id)
    { // Создание нового элемента
        Link newLink = new Link(id);
        newLink.next = first; // newLink --> старое значение first
        first = newLink; // first --> newLink
    }

    //вставка после заданного элемента
    public void insertAfter(T id, T after)
    {
        if(first== null){
            System.out.println("Список был пуст. Вставка первого элемента");
            insertFirst(id);
        } else {
            Link<T> lnk= first;
            Link<T> newLink=new Link<>(id);
            while (lnk.next!= null) {

                if(lnk.iData.equals(after))
                {
                    Link<T> temp= lnk.next;
                    lnk.next= newLink;
                    newLink.next=temp;
                }
                lnk= lnk.next;
            }
        }
    }

    // удаление элемента
    public Link deleteFirst() // Удаление первого элемента
    {   // (предполагается, что список не пуст)
        Link temp = first; // Сохранение ссылки
        first = first.next; // Удаление: first-->ссылка на второй элемент
        return temp; // Метод возвращает ссылку
    } // на удаленный элемент


    // проход по списку с выводом на экран информационных частей элементов
    public void displayList()
    {
        Link current = first; // От начала списка
        while(current != null) // Перемещение до конца списка
        {
            current.displayLink(); // Вывод данных
            current = current.next; // Переход к следующему элементу
        }
        System.out.println("");
    }

    // поиск элемента с заданной информационной частью
    public Boolean contains(T id){
        Link current= first;
        while (current!= null){
            if(current.iData.equals(id))
                return true;
            current= current.next;
        }
        return false;
    }
}

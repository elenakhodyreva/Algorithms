package structures;

import models.Link;

public class DoubleLinkedList<E> {

    private Link first;
    private Link last;

    //для списка списков
    public DoubleLinkedList previous;
    public DoubleLinkedList next;

    public Link getFirst() {
        return first;
    }

    public DoubleLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(E dd) // Вставка элемента в начало списка
    {
        Link newLink = new Link(dd); // Создание нового элемента
        if (isEmpty()) // Если список не содержит элементов,
            last = newLink; // newLink <-- last
        else
            first.previous = newLink; // newLink <-- старое значение first
        newLink.next = first; // newLink --> старое значение first
        first = newLink; // first --> newLink
    }

    //	просмотр списка в прямом и обратном направлениях
    public void displayForward() {
        System.out.print("В прямом направлении: ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public void displayBackward() {
        System.out.print("В обратном направлении: ");
        Link current = last;
        while (current != null) {
            current.displayLink();
            current = current.previous;
        }
        System.out.println("");
    }

    //	добавление элемента перед или после заданного

    // после заданного
    public boolean insertAfter(E key, E dd) {
        Link current = first; // От начала списка
        while (current.dData != key) // Пока не будет найдено совпадение
        {
            current = current.next; // Переход к следующему элементу
            if (current == null)
                return false; // Ключ не найден
        }

        Link newLink = new Link(dd); // Создание нового элемента
        if (current == last) // Для последнего элемента списка
        {
            newLink.next = null; // newLink --> null
            last = newLink; // newLink <-- last
        } else // Не последний элемент
        {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
        return true;
    }

    //перед заданным
    public boolean insertBefore(E key, E dd) {
        Link current = last; // От конца списка
        while (current.dData != key) // Пока не будет найдено совпадение
        {
            current = current.previous; // Переход к следующему элементу
            if (current == null)
                return false; // Ключ не найден
        }

        Link newLink = new Link(dd); // Создание нового элемента
        if (current == first) // Для первого элемента списка
        {
            newLink.previous = null; // newLink --> null
            first = newLink; // newLink <-- last
        } else // Не первый элемент
        {
            newLink.previous = current.previous;
            current.previous.next = newLink;
        }
        newLink.next = current;
        current.previous = newLink;
        return true;
    }

    //	удаление заданного элемента
    public Link deleteKey(E key) // Удаление элемента с заданным ключом
    {
        Link current = first; // От начала списка
        while (current.dData != key) // Пока не будет найдено совпадение
        {
            current = current.next; // Переход к следующему элементу
            if (current == null)
                return null; // Ключ не найден
        }
        if (current == first) // Ключ найден; это первый элемент?
            first = current.next; // first --> старое значение next
        else // Не первый элемент
            current.previous.next = current.next;

        if (current == last) // Последний элемент?
            last = current.previous; // старое значение previous <-- last
        else // Не последний элемент
            current.next.previous = current.previous;
        return current; // Возвращение удаленного элемента
    }

    //	поиск заданного элемента в прямом и обратном направлениях
    public boolean findForward(E key) {
        Link current = first; // От начала списка
        while (current.dData != key) // Пока не будет найдено совпадение
        {
            current = current.next; // Переход к следующему элементу
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    public boolean findBackward(E key) {
        Link current = last; // От конца списка
        while (current.dData != key) // Пока не будет найдено совпадение
        {
            current = current.previous; // Переход к следующему элементу
            if (current == null) {
                return false;
            }
        }
        return true;
    }
}

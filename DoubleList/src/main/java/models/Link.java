package models;

public class Link<E> {
    public E dData; // Данные
    public Link next; // Следующий элемент в списке
    public Link previous; // Предыдущий элемент в списке

    public Link(E d) {
        dData = d;
    }

    public void displayLink() // Вывод содержимого элемента
    {
        System.out.print(dData + " ");
    }
}

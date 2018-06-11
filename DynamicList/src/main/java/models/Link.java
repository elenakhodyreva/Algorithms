package models;

public class Link<T> {
    public T iData; // Данные
    public Link next; // Следующий элемент в списке

    public Link(T id) // Конструктор
    {
        iData = id; // Инициализация данных
        next= null; // хотя и java по умолчанию присваивает null
    }

    public void displayLink() // Вывод содержимого элемента
    {
        System.out.print(" " + iData);
    }
}

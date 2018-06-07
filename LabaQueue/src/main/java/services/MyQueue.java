package services;

public class MyQueue {
    private int[] qArray;
    private int top;
    private int end;
    private int nItems;

    public MyQueue(int s) // Конструктор
    {
        qArray = new int[s];
        top = 0;
        end = -1;
        nItems = 0;
    }

    public void insert(int j) // Вставка элемента в конец очереди
    {
        if(nItems==qArray.length)
        {
            int temp[]= new int[qArray.length*2];
            for (int i = 0; i < qArray.length; i++) {

                temp[i]= qArray[i];
            }
            qArray= temp;
        }

        if(end == (qArray.length-1)) // Циклический перенос
            end = -1;
        qArray[++end] = j; // Увеличение rear и вставка
        nItems++; // Увеличение количества элементов

    }

    public int remove() // Извлечение элемента в начале очереди
    {
        int temp = qArray[top++]; // Выборка и увеличение front
        if(top == qArray.length) // Циклический перенос
            top = 0;
        nItems--; // Уменьшение количества элементов
        return temp;

    }

    public int peekFront() // Чтение элемента в начале очереди
    {
        return qArray[top];
    }

    public boolean isEmpty() // true, если очередь пуста
    {
        return (nItems==0);
    }

    public boolean isFull() // true, если очередь заполнена
    {
        return (nItems==qArray.length);
    }

    public int size()
    {
        return qArray.length;
    }
}

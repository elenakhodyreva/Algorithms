package services;

import com.sun.org.apache.xpath.internal.operations.Bool;

public interface IMyStack<E> {

    public void push(E j);
    public E pop();
    public E peek();
    public Boolean isEmpty();
    public Boolean isFull();
    public void pushSomeValues(Integer count);
}

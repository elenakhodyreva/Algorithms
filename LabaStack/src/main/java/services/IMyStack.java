package services;

import com.sun.org.apache.xpath.internal.operations.Bool;

public interface IMyStack {

    public void push(Integer j);
    public Integer pop();
    public Integer peek();
    public Boolean isEmpty();
    public Boolean isFull();
    public void pushSomeValues(Integer count);
}

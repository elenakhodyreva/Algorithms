import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import services.MyStack;

import java.util.Random;

import static org.junit.Assert.*;

public class MyStackTest {

    private MyStack<Integer> stack;
    Random random;

    @Before
    public void init(){
        stack= new MyStack<>(5);
        random= new Random();
    }

    @After
    public void endTest(){
        stack= null;
    }

    //1 при создании стека равен ли top -1
    @Test
    public void isTopMinusOne(){
        assertEquals(-1, (Object)stack.top);
    }

    //2 сразу после добавления первого элемента размер стека равен 1
    @Test
    public void stackSizeIsOne(){
        stack.push(random.nextInt(100)+1);
        assertEquals(1, (Object)stack.size());
    }

    //3 полон ли стек когда добавили все элементы
    @Test
    public void isStackFullAfterAllInsertions(){
        for (int i=0; i<5; i++){
            stack.push(random.nextInt(100)+1);
        }
        assertTrue(stack.isFull());
    }

    //4 сначала добавили значения динамически, потом очистили. Будет ли пуст
    @Test
    public void isStackEmpty(){
        for (int i=0; i<5; i++){
            stack.push(random.nextInt(100)+1);
        }
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    //5 сначала добавили значения динамически, потом очистили. Будет ли top опять минус 1
    @Test
    public void isTopAgainMinusOne(){
        for (int i=0; i<5; i++){
            stack.push(random.nextInt(100)+1);
        }
        stack.clear();
        assertEquals(-1, (Object)stack.top);
    }


    //6 Нужное ли значение на вершине после вставки данного значения
    @Test
    public void isPopWorks(){
        stack.push(3);
        assertEquals(3, (Object)stack.pop());
    }

    //7 После вставки двух значений и удаления одного, осталось ли нужное значение на вершине стека
    @Test
    public void isPeekWorks(){
        stack.push(15);
        stack.push(3);
        stack.pop();
        assertEquals(15, (Object)stack.peek());
    }

    //8 Правильно ли показывает вершину при динамической вставке нескольких значений
    @Test
    public void isTopGreatThanFive(){
        for (int i=0; i<15; i++){
            stack.push(random.nextInt(100)+1);
        }
        assertTrue(stack.top==14);
    }

    //9 После вставки количества большего чем изначальная емкость, правильно ли динамически увеличилась емкость
    @Test
    public void isCapacityGrown(){
        for (int i=0; i<15; i++){
            stack.push(random.nextInt(100)+1);
        }
        // после вставки более 5ти 5*2=10
        // после вставки более 10ти 10*2=20
        assertTrue(stack.capacity()==20);
    }

    //10 Вместо цикла for использую один метод вставить сразу 15 значений, top должен показывать на 14й
    @Test
    public void isPushSomeValuesWorks(){

        stack.pushSomeValues(15);
        assertTrue(stack.top==14);
    }
}

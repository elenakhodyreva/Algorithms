package structures;

public class MyArrayList<T> {
    private final int INIT_SIZE = 5;
    private Object[] array;
    private int items;

    public MyArrayList(){
        array = new Object[INIT_SIZE];
        items  = 0;
    }


    public void add(T item){

        checkArrayLength(array);
        array[items++]= item;
    }

    public void insertBefore(T item, Integer index){
        checkArrayLength(array);

        Object temp[]= new Object[array.length];
        int i=0;
        for (i = 0; i < index; i++){
            temp[i]=array[i];
        }

        temp[index++]= item;
        for (; i < items ; i++) {
            temp[index++]=array[i];
        }
        array=temp;
        items++;
    }

    public void insertAfter(T item, int index) {

        checkArrayLength(array);

        if(items==0){
            array[items++]= item;
        } else{
            for (int i= (items-1); i>index; i--){
                array[i+1]= array[i];
            }
            array[index+1]= item;
            items++;
        }
    }

    public T get(int index) {
        return (T) array[index];
    }

    public void remove(int index) {
        for (int i = index; i<items; i++)
            array[i] = array[i+1];
        array[items] = null;
        items--;
    }

    public int size() {
        return items;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, items);
        array = newArray;
    }

    private void checkArrayLength(Object[] arr){

        if(items == arr.length-1)
            resize(arr.length*2);
    }

    public void printArrayList(){
        for(int i=0; i<items; i++){
            System.out.print(" "+ array[i]);
        }
    }

    public boolean isEmpty(){
        return (items==0);
    }

    public Integer contains(T item){
        for(int i=0; i<items; i++){
            if(array[i].equals(item)){
                return i;
            }
        }
        return -1;
    }
}

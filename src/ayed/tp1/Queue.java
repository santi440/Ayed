package tp1;
import java.util.*;
public class Queue<T> extends Sequence<T> {
    List<T> data;
    
    public Queue() {
    this.data = new LinkedList<T>();
    }
    public void enqueue(T dato) {
    // agrega al final
        data.add(dato);
    }
    public T dequeue() {
        return data.remove(0);
    }
    public T head() {
        return data.get(0);
    } 
    @Override
    public int size() {
        return data.size();
    }
    @Override
    public boolean isEmpty() {
        return data.size()==0;
    }
    @Override
    public String toString() {
        String str = "[";
        for(T d: data)
            str = str + d +", ";
        str = str.substring(0, str.length()-2)+"]";
        return str;
    }
}

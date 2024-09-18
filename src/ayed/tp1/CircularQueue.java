package tp1;
public class CircularQueue<T> extends Queue<T> {
    public T shift(){
        T elem = (T)super.dequeue(); 
        super.enqueue(elem);
        return  elem;
    }
}
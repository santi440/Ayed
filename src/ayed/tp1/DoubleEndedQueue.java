package tp1;
public class DoubleEndedQueue<T> extends Queue<T>{
    public void enqueueFirst(T elem){
        super.data.add(0, elem);
    }
}

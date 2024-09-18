package ayed.tp1.ejercicio8;

public class CircularQueue<T> extends Queue<T> {
	public T shift () {
		T temp = super.dequeue();
		super.enqueue(temp);
		return temp;
	}

}

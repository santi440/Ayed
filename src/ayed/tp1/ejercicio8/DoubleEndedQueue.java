package ayed.tp1.ejercicio8;

public class DoubleEndedQueue<T> extends Queue<T> {
	public void enqueueFirst(T elemento) {
		super.data.add(0, elemento);
	}
}

package interfaces;

import java.util.stream.Stream;

public interface ILista<T> extends Iterable<T>{
	public void add(int position, T element);
	public boolean add(T element);
	public boolean add(T element, int position);
	public T remove(int position);
	public T remove(T element);
	public T get(int position);
	public T set(int position, T element);
	public int size();
	public boolean isEmpty();
	public Stream<T> stream();
	public T next();
	public T find(T Element);
}

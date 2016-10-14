package lista;

import java.util.Iterator;
import java.util.Queue;
import java.util.stream.Stream;

import interfaces.ILista;

public class Lista<T> implements ILista<T> {

	private No<T> header;
	private int size;
	private No<T> filaNext;

	public Lista() {
		this.header = new No<T>(null, null);
		this.size = 0;
		this.filaNext = this.header;
	}

	public void add(int position, T element) {
		if (position == 0) {
			if (size == 0) {
				header.setElement(element);
			} else {
				header = new No<T>(element, header);
			}
		} else if ((position - 1) != size) {
			No<T> aux = atRank(position);
			aux.setNext(new No<T>(element, aux.getNext()));
		} else {
			No<T> aux = atRank(position);
			aux.setNext(new No<T>(element, null));
		}
		size++;

	}

	public boolean add(T element) {
		No<T> aux = header;
		if (size > 0) {
			aux = atRank(size - 1);
			aux.setNext(new No<T>(element, null));
		} else {
			aux.setElement(element);
		}
		size++;
		return true;
	}

	@Override
	public boolean add(T element, int position) {
		No<T> aux = this.header;
		if (this.size > 0) {
			aux = atRank(position - 1);
			aux.setNext(new No<T>(element, aux.getNext()));
		} else {
			aux.setElement(element);
		}
		size++;
		return true;
	}

	public T remove(int position) {
		No<T> aux = atRank(position - 1);
		T elementRemoved = aux.getElement();

		aux.setNext(aux.getNext());

		return elementRemoved;
	}

	@Override
	public T remove(T element) {
		T elementoARemover = this.find(element);
		if (elementoARemover != null) {
			No<T> aux = this.header;

			while (aux.getNext() != null) {
				if (aux.getElement() == element) {
					aux.setNext(aux.getNext().getNext());
				}
				aux = aux.getNext();
			}
		}

		return elementoARemover;
	}

	public T get(int position) {
		return atRank(position).getElement();
	}

	public T set(int position, T element) {
		No<T> aux = atRank(position);
		T elementUpdated = aux.getElement();

		aux.setElement(element);

		return elementUpdated;
	}

	public T next() {
		if (this.filaNext != null) {
			T element = this.filaNext.getElement();
			this.filaNext = this.filaNext.getNext();

			return element;
		}

		return null;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	protected No<T> atRank(int pos) {
		if (isValid(pos)) {
			No<T> aux = header;
			for (int i = 0; i < pos; i++) {
				aux = aux.getNext();
			}
			return aux;
		}
		return null;
	}

	private boolean isValid(int pos) {
		if (pos >= 0 && pos < size)
			return true;
		return false;
	}

	@Override
	public Stream<T> stream() {
		return Stream.of(header.getElement());
	}

	@Override
	public Iterator<T> iterator() {
		return new MyInterator<T>(this);
	}

	@Override
	public T find(T Element) {
		No<T> NoAux = this.header;

		while (NoAux.getNext() != null && NoAux != null) {

			if (NoAux.getElement() == Element) {
				return NoAux.getElement();
			}

			NoAux = NoAux.getNext();

		}

		return null;
	}
	
	@Override
	public String toString(){
		No<T> aux = this.header;
		String mensagem = aux.getElement().toString();
		
		aux = aux.getNext();
		
		while(aux != null){
			mensagem +=   " " + aux.getElement().toString();
			aux = aux.getNext();
		}
		
		return mensagem;
		
	}

}

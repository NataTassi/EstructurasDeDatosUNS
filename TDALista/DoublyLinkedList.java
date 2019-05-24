package TDALista;

import java.util.Iterator;

public class DoublyLinkedList<E> implements PositionList<E> {
	protected DNode<E> header,trailer;
	protected int size;
	
	public DoublyLinkedList(){
		header = new DNode<E>();
		trailer = new DNode<E>();
		header.setPrev(null);
		header.setNext(trailer);
		trailer.setPrev(header);
		trailer.setNext(null);
		size = 0;
	}
	
	@Override
	public int size(){
		return size;
	}
	
	@Override
	public boolean isEmpty(){
		return size == 0;
	}
	
	@Override
	public Position<E> first() throws EmptyListException{
		if(size == 0) throw new EmptyListException("Empty list getting first");
		return header.getNext();
	}
	@Override
	public Position<E> last() throws EmptyListException{
		if(size == 0) throw new EmptyListException("Empty list getting last");
		return trailer.getPrev();
	}
	
	private DNode<E> checkPosition(Position<E> p) throws InvalidPositionException{
		if(p == null) throw new InvalidPositionException("Invalid position, it's null");
		try{
			return (DNode<E>) p;	
		} catch(ClassCastException e){
			throw new InvalidPositionException("Invalid position, it isn't a proper node");
		}
	} 
	
	@Override
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNode<E> n = checkPosition(p);
		try {
			if(n == first()) throw new BoundaryViolationException("There's no previous node");
			return n.getPrev();
		} catch(EmptyListException e){
			throw new InvalidPositionException("Empty list while getting prev");
		}
	}
	@Override
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNode<E> n = checkPosition(p);
		try {
			if(n == last()) throw new BoundaryViolationException("There's no next node");
			return n.getNext();
		} catch(EmptyListException e){
			throw new InvalidPositionException("Empty list while getting next");
		}
	}
	
	@Override
	public void addFirst(E e){
		DNode<E> n = new DNode<E>(e,header,header.getNext());
		header.getNext().setPrev(n);
		header.setNext(n);
		
		size++;
	}
	@Override
	public void addLast(E e){
		DNode<E> n = new DNode<E>(e,trailer.getPrev(),trailer);
		trailer.getPrev().setNext(n);
		trailer.setPrev(n);
		size++;
	}
	
	@Override
	public void addBefore(Position<E> p, E e) throws InvalidPositionException{
		if(size == 0) throw new InvalidPositionException("Empty list while adding before");
		DNode<E> pos = checkPosition(p);
		DNode<E> newNode = new DNode<E>(e,pos.getPrev(),pos);
		pos.getPrev().setNext(newNode);
		pos.setPrev(newNode);
		size++;
	}
	@Override
	public void addAfter(Position<E> p, E e) throws InvalidPositionException{
		if(size == 0) throw new InvalidPositionException("Empty list while adding after");
		DNode<E> pos = checkPosition(p);
		DNode<E> newNode = new DNode<E>(e,pos,pos.getNext());		
		pos.getNext().setPrev(newNode);
		pos.setNext(newNode);
		size++;
	}
	
	@Override
	public E remove(Position<E> p) throws InvalidPositionException{
		if(size == 0) throw new InvalidPositionException("Empty list while removing");
		DNode<E> n = checkPosition(p);
		DNode<E> prev = n.getPrev(), next = n.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		size--;
		return n.element();
	}
	
	@Override
	public E set(Position<E> p, E e) throws InvalidPositionException{
		if(size == 0) throw new InvalidPositionException("Empty list while setting new value");
		DNode<E> n = checkPosition(p);
		E res = n.element();
		n.setElem(e);
		return res;
	}
	
	@Override
	public Iterator<E> iterator(){
		return new ElementIterator<E>(this);
	}
	@Override
	public Iterable<Position<E>> positions(){
		PositionList<Position<E>> res = new DoublyLinkedList<Position<E>>();
		DNode<E> n = header.getNext();
		while(n != trailer){
			res.addLast(n);
			n = n.getNext();
		}
		return res;
	}
	
	public String toString(){
		String r = "[";
		Iterator<E> it = iterator();
		while(it.hasNext()) r += it.next() + (it.hasNext() ? "," : "]");
		return r;
	}
}

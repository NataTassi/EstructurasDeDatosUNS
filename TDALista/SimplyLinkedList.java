package TDALista;
import java.util.Iterator;

public class SimplyLinkedList<E> implements PositionList<E> {
	protected Node<E> head,tail;
	protected int size;
	
	public SimplyLinkedList(){ head = tail = null; size = 0; }
	
	@Override
	public int size(){ return size;	}
	
	@Override
	public boolean isEmpty(){ return size == 0;	}
	
	@Override
	public Position<E> first() throws EmptyListException{
		if(size == 0) throw new EmptyListException("List is empty");
		return head;
	}
	@Override
	public Position<E> last() throws EmptyListException{
		if(size == 0) throw new EmptyListException("List is empty");
		return tail;
	}
	
	private Node<E> checkPosition(Position<E> p) throws InvalidPositionException{
		if(size == 0) throw new InvalidPositionException("List is empty");
		if(p == null) throw new InvalidPositionException("Invalid position, it's null");
		try {	
			return (Node<E>) p;
		} catch(ClassCastException e) {
			throw new InvalidPositionException("Invalid position, it isn't a proper node");
		}
	}
	
	@Override
	public Position<E> prev(Position<E> p) throws InvalidPositionException,BoundaryViolationException {
		Node<E> n = checkPosition(p);
		if(n == head) throw new BoundaryViolationException("There's no previous node");
		Node<E> tmp = head;
		while(tmp.getNext() != null && tmp.getNext() != n)
			tmp = tmp.getNext();
		return tmp;
	}
	@Override
	public Position<E> next(Position<E> p) throws InvalidPositionException,BoundaryViolationException {
		Node<E> n = checkPosition(p);
		if(n == tail) throw new BoundaryViolationException("There's no next node");
		return n.getNext();
	}	
	
	@Override
	public void addFirst(E e) {
		head = new Node<E>(e,head);
		if(size++ == 0) tail = head;
	}
	@Override
	public void addLast(E e) {
		if(size == 0) addFirst(e);
		else {
			Node<E> tmp = new Node<E>(e);
			tail.setNext(tmp);
			tail = tmp;
			size++;
		}
	}
	
	@Override
	public void addBefore(Position<E> p, E e) throws InvalidPositionException{
		Node<E> n = checkPosition(p);
		try {
			if(n == head) addFirst(e);
			else {
				Node<E> tmp = (Node<E>) prev(p);
				tmp.setNext(new Node<E>(e,n));
				size++;
			}
		} catch(BoundaryViolationException f) {
			throw new InvalidPositionException("Invalid previous position");
		}
	}
	@Override
	public void addAfter(Position<E> p, E e) throws InvalidPositionException{
		Node<E> n = checkPosition(p);
		if(n == tail) addLast(e);
		else {
			n.setNext(new Node<E>(e,n.getNext()));
			size++;
		}
	}
	
	@Override
	public E remove(Position<E> p) throws InvalidPositionException{
		Node<E> n = checkPosition(p);
		if(size == 1) {
			if(n == head) head = tail = null;
			else throw new InvalidPositionException("Position doesn't belong to the list");
		}
        else try {
			if(n == head) head = head.getNext();
			else {
				Node<E> prev = (Node<E>) prev(p);
				if(n == tail) tail = prev;
				else prev.setNext(n.getNext());
			}
		} catch(BoundaryViolationException e) {
			throw new InvalidPositionException("Invalid previous position");
		}
		size--;
		return n.element();
	}
	
	@Override
	public E set(Position<E> p, E e) throws InvalidPositionException{
        Node<E> n = checkPosition(p);
        E tmp = n.element();
        n.setElem(e);
        return tmp;
	}
	
	@Override
    public Iterator<E> iterator(){ return new ElementIterator<E>(this); }

	@Override
    public Iterable<Position<E>> positions(){
    	PositionList<Position<E>> r = new SimplyLinkedList<Position<E>>();
        Node<E> n = head;
        while(n != null) {
        	r.addLast(n);
            n = n.getNext();
        }
       return r;
    }
    
	@Override
	public String toString(){
		String r = "[";
		Iterator<E> it = iterator();
		while(it.hasNext()) r += it.next() + (it.hasNext() ? "," : "]");
		return r;
	}
}

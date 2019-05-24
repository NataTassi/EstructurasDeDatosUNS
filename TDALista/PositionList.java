package TDALista;
import java.util.Iterator;

public interface PositionList<E> extends Iterable<E>{
	public int size();
	public boolean isEmpty();
	public Position<E> first() throws EmptyListException;
	public Position<E> last() throws EmptyListException;
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException;
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException;
	public void addFirst(E element);
	public void addLast(E element);
	public void addAfter(Position<E> p, E element) throws InvalidPositionException;
	public void addBefore(Position<E> p, E element) throws InvalidPositionException;	
	public E remove(Position<E> p) throws InvalidPositionException;
	public E set(Position<E> p, E element) throws InvalidPositionException;
	public Iterator<E> iterator();
	public Iterable<Position<E>> positions();
}
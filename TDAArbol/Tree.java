package TDAArbol;
import java.util.Iterator;

public interface Tree<E> extends Iterable<E>{
	public int size();
	public boolean isEmpty();
	public Iterator<E> iterator();
	public Iterable<Position<E>> positions();
	public E replace(Position<E> v, E e) throws InvalidPositionException;
	
	public Position<E> root() throws EmptyTreeException;
	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException;
	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException;
	
	public boolean isInternal(Position<E> v) throws InvalidPositionException;
	public boolean isExternal(Position<E> v) throws InvalidPositionException;
	public boolean isRoot(Position<E> v) throws InvalidPositionException;
	
	public void createRoot(E e) throws InvalidOperationException;
	public Position<E> addFirstChild(Position<E> p, E e) throws	InvalidPositionException;
	public Position<E> addLastChild(Position<E> p, E e) throws InvalidPositionException;
	public Position<E> addBefore(Position<E> p, Position<E> rb, E e) throws InvalidPositionException;
	public Position<E> addAfter (Position<E> p, Position<E> lb, E e) throws InvalidPositionException;
	public void removeExternalNode (Position<E> p) throws InvalidPositionException;
	public void removeInternalNode (Position<E> p) throws InvalidPositionException;
	public void removeNode (Position<E> p) throws InvalidPositionException;
}
package TDAPila;
import TDALista.*;

/**
 * Class ListStack.
 * Implementa Stack.
 * Representa una pila con una lista.
 *
 * @param <E> Tipo de los elementos almacenados.
 */
public class ListStack<E> implements Stack<E> {
	protected PositionList<E> list;
	
	/**
	 * Crea una pila vacía.
	 */
	public ListStack(){ list = new SimplyLinkedList<E>(); }
	
	@Override
	public void push(E e){ list.addLast(e); }
	
	@Override
	public E pop() throws EmptyStackException{
		try {
			return list.remove(list.last());
		} catch(EmptyListException | InvalidPositionException e){
			throw new EmptyStackException("Stack is empty");
		}
	}
	
	@Override
	public E top() throws EmptyStackException{
		try {
			return list.last().element();
		} catch(EmptyListException e){
			throw new EmptyStackException("Stack is empty");
		}
	}	
		
	@Override
	public boolean isEmpty(){ return list.isEmpty(); }
	
	@Override
	public int size(){ return list.size(); }
}

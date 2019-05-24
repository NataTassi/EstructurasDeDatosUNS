package TDAPila;
import TDALista.*;

public class ListStack<E> implements Stack<E> {
	protected PositionList<E> list;
	
	public ListStack(){
		list = new SimplyLinkedList<E>();
	}
	
	@Override
	public void push(E e){
		list.addLast(e);
	}
	
	@Override
	public E pop() throws EmptyStackException{
		try {
			return list.remove(list.last());
		} catch(EmptyListException | InvalidPositionException e){
			throw new EmptyStackException("Empty stack while popping");
		}
	}
	
	@Override
	public E top() throws EmptyStackException{
		try {
			return list.last().element();
		} catch(EmptyListException e){
			throw new EmptyStackException("Empty stack while getting top");
		}
	}	
		
	@Override
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	@Override
	public int size(){
		return list.size();
	}
}
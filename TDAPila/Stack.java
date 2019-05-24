package TDAPila;

public interface Stack<E> {
	public int size();
	public boolean isEmpty();
	public E top()throws EmptyStackException;
	public void push(E e);
	public E pop() throws EmptyStackException;
}
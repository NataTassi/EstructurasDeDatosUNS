package TDAPila;

/**
 * Class LinkedStack.
 * Implementa Stack. 
 * Representa una pila con nodos enlazados.
 *
 * @param <E> Tipo de los elementos almacenados.
 */
public class LinkedStack<E> implements Stack<E>{
	protected Node<E> head;
	protected int size;
	
	/**
	 * Crea una pila vacía.
	 */
	public LinkedStack(){ head = null; size = 0; }
	
	@Override
	public int size(){ return size; }
	
	@Override
	public boolean isEmpty(){ return size == 0; }
	
	@Override
	public E top() throws EmptyStackException{
		if(size == 0) throw new EmptyStackException("Stack is empty");
		return head.element();
	}
	
	@Override
	public void push(E elem){
		head = new Node<E>(elem,head);
		size++;
	}
	
	@Override
	public E pop() throws EmptyStackException{
		if(size == 0) throw new EmptyStackException("Stack is empty");
		E tmp = head.element();
		head = head.getNext();
		size--;
		return tmp;
	}
}

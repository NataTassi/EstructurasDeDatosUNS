package TDAPila;

public class LinkedStack<E> implements Stack<E>{
	protected Node<E> head;
	protected int size;
	
	public LinkedStack(){ head = null; size = 0; }
	
	@Override
	public int size(){ return size; }
	
	@Override
	public boolean isEmpty(){ return size == 0; }
	
	@Override
	public E top() throws EmptyStackException{
		if(size == 0) throw new EmptyStackException("Stack is empty");
		return head.getElem();
	}
	
	@Override
	public void push(E elem){
		head = new Node<E>(elem,head);
		size++;
	}
	
	@Override
	public E pop() throws EmptyStackException{
		if(size == 0) throw new EmptyStackException("Stack is empty");
		E tmp = head.getElem();
		head = head.getNext();
		size--;
		return tmp;
	}
}

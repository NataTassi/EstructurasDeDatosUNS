package TDACola;

public class LinkedQueue<E> implements Queue<E> {
	protected Node<E> head,tail;
	protected int size;
	
	public LinkedQueue(){ head = tail = null; size = 0; }
	
	@Override
	public void enqueue(E e){
		Node<E> tmp = new Node<E>(e);
		if(size == 0) head = tmp;
		else tail.setNext(tmp);
		tail = tmp;
		size++;
	}
	
	@Override
	public E dequeue() throws EmptyQueueException{
		if(size == 0) throw new EmptyQueueException("Queue is empty");
		E tmp = head.getElem();
		head = head.getNext();
		size--;
		if(size == 0) tail = null;
		return tmp;
	}
	
	@Override
	public E front() throws EmptyQueueException{
		if(size == 0) throw new EmptyQueueException("Queue is empty");
		return head.getElem();
	}
	
	@Override
	public boolean isEmpty(){ return size == 0; }
	
	@Override
	public int size(){ return size; }
}

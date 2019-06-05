package TDACola;
import TDALista.*;

/**
 * Class ListQueue.
 * Implementa Queue. 
 * Representa una cola con una lista.
 *
 * @param <E> Tipo de los elementos almacenados.
 */
public class ListQueue<E> implements Queue<E> {
	protected PositionList<E> list;
	
	/**
	 * Crea una cola vacía.
	 */
	public ListQueue(){ list = new SimplyLinkedList<E>(); }
	
	@Override
	public void enqueue(E e){ list.addLast(e); }
	
	@Override
	public E dequeue() throws EmptyQueueException{
		try {
			return list.remove(list.first());
		} catch(EmptyListException | InvalidPositionException e){
			throw new EmptyQueueException("Queue is empty");
		}
	}
	
	@Override
	public E front() throws EmptyQueueException{
		try {
			return list.first().element();
		} catch(EmptyListException e){
			throw new EmptyQueueException("Queue is empty");
		}
	}	
	
	@Override
	public boolean isEmpty(){return list.isEmpty(); }
	
	@Override
	public int size(){ return list.size(); }
}

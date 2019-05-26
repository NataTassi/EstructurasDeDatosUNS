package TDALista;

/**
 * Class DNode.
 * Implementa Position.
 * Representa un nodo de DoublyLinkedList.
 *
 * @param <E> Tipo de los elementos almacenados por DoublyLinkedList.
 */
public class DNode<E> implements Position<E>{
	protected E elem;
	protected DNode<E> prev,next;
	
	/** 
	 * Instancia un objeto de tipo DNode, establece el elemento del nodo, el nodo previo y el siguiente.
	 * @param e Elemento del nodo.
	 * @param p Nodo previo.
	 * @param n Nodo siguiente.
	 */
	public DNode(E e, DNode<E> p, DNode<E> n){ elem = e; prev = p;	next = n; }
	
	/**
	 * Instancia un objeto de tipo DNode con todas sus referencias nulas.
	 */
	public DNode(){ this(null,null,null); }
	
	/**
	 * Establece el elemento del nodo.
	 * @param e Elemento del nodo.
	 */
	public void setElem(E e){ elem = e;	}
	
	/**
	 * Establece el nodo previo.
	 * @param p Nodo a establecer como previo.
	 */
	public void setPrev(DNode<E> p){ prev = p; }
	
	/**
	 * Establece el nodo siguiente.
	 * @param n Nodo a establecer como siguiente.
	 */
	public void setNext(DNode<E> n){ next = n; }
	
	@Override
	public E element(){ return elem; }
	
	/**
	 * Retorna el nodo previo o null si este no existe.
	 * @return Nodo previo.
	 */
	public DNode<E> getPrev(){ return prev; }
	
	/**
	 * Retorna el nodo siguiente o null si este no existe.
	 * @return Nodo siguiente.
	 */
	public DNode<E> getNext(){ return next;	}
}
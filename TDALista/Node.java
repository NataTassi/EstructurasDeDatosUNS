package TDALista;

/**
 * Class Node.
 * Representa un nodo de SimplyLinkedList.
 *
 * @param <E> Tipo de los elementos almacenados por la lista.
 */
public class Node<E> implements Position<E>{
	protected E elem;
	protected Node<E> next;
	
	/**
	 * Crea un nodo con el elemento y el nodo siguiente dados.
	 * @param e Elemento del nodo.
	 * @param n Nodo siguiente.
	 */
	public Node(E e, Node<E> n){ elem = e; next = n; }
	
	/**
	 * Crea un nodo con el elemento dado.
	 * @param e Elemento del nodo.
	 */
    public Node(E e){ this(e,null); }
	
	/**
	 * Establece el elemento del nodo.
	 * @param e Elemento del nodo.
	 */
	public void setElem(E e){ elem = e; }

	/**
	 * Establece el nodo siguiente.
	 * @param n Nodo a establecer como siguiente.
	 */
	public void setNext(Node<E> n){ next = n; }
	
	@Override
	public E element(){ return elem; }

	/**
	 * Retorna el nodo siguiente o null si este no existe.
	 * @return Nodo siguiente.
	 */
	public Node<E> getNext(){ return next; }
}

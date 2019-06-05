package TDAArbol;
import TDALista.*;

/**
 * Class TNode.
 * Implementa Position.
 * Representa un nodo de LinkedTree.
 *
 * @param <E> Tipo de los elementos almacenados.
 */
public class TNode<E> implements Position<E> {
	protected E elem;
	protected TNode<E> parent;
	protected PositionList<TNode<E>> children;
	
	/**
	 * Crea un nodo con el elemento y nodo a establecer como padre dados, y crea una lista vacía de hijos.
	 * @param e Elemento del nodo.
	 * @param p Padre del nodo.
	 */
	public TNode(E e, TNode<E> p) {
		elem = e; parent = p; 
		children = new DoublyLinkedList<TNode<E>>();
	}
	/**
	 * Crea un nodo con elemento dado, su padre con referencia nula, y crea una lista vacía de hijos.
	 * @param e Elemento del nodo.
	 */
	public TNode(E e){ this(e,null); }

	@Override
	public E element() { return elem; }
	/**
	 * Retorna el padre del nodo.
	 * @return Padre del nodo.
	 */
	public TNode<E> getParent() { return parent; }
	/**
	 * Retorna los hijos del nodo.
	 * @return Hijos del nodo.
	 */
	public PositionList<TNode<E>> getChildren(){ return children; }
	
	/**
	 * Establece el elemento del nodo.
	 * @param e Elemento del nodo.
	 */
	public void setElement(E e){ elem = e; }
	/**
	 * Establece el padre del nodo.
	 * @param p Nuevo padre del nodo.
	 */
	public void setParent(TNode<E> p){ parent = p; }
	/**
	 * Establece los hijos del nodo.
	 * @param c Nuevos hijos del nodo. 
	 */
	public void setChildren(PositionList<TNode<E>> c){ children = c; }
}

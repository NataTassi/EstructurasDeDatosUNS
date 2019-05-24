package TDALista;

public class Node<E> implements Position<E>{
	protected E elem;
	protected Node<E> next;
	
	public Node(E e, Node<E> n){
		elem = e;
		next = n;
	}
	public Node(E elem){
		this(elem,null);
	}
	
	public void setElem(E e){
		elem = e;
	}
	public void setNext(Node<E> n){
		next = n;
	}
	
	public E element(){
		return elem;
	}
	public E getElem(){
		return elem;
	}
	public Node<E> getNext(){
		return next;
	}
}

package TDACola;

public class Node<E>{
	private E elem;
	private Node<E> next;
	
	public Node(E e, Node<E> n){
		elem = e;
		next = n;
	}
	
    public Node() {
		this(null,null);
	}
	
    public Node(E e){
		this(e,null);
	}
	
	public void setElem(E e){
		elem = e;
	}

	public void setNext(Node<E> n){
		next = n;
	}
	
	public E getElem(){
		return elem;
	}

	public Node<E> getNext(){
		return next;
	}
}

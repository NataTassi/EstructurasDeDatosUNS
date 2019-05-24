package TDALista;

public class DNode<E> implements Position<E>{
	protected E elem;
	protected DNode<E> prev,next;
	
	public DNode(E e, DNode<E> p, DNode<E> n){
		elem = e;
		prev = p;
		next = n;
	}
	public DNode(){
		this(null,null,null);
	}
	
	public void setElem(E e){
		elem = e;
	}
	public void setPrev(DNode<E> p){
		prev = p;
	}
	public void setNext(DNode<E> n){
		next = n;
	}
	
	public E element(){
		return elem;
	}
	public DNode<E> getPrev(){
		return prev;
	}
	public DNode<E> getNext(){
		return next;
	}
}

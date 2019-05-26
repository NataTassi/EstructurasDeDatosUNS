package TDAArbol;
import TDALista.*;
import java.util.Iterator;

/**
 * Class LinkedTree.
 * Implementa Tree. 
 * Representa un árbol general con colección de hijos y referencia al padre.
 *
 * @param <E> Tipo de los elementos almacenados.
 */
public class LinkedTree<E> implements Tree<E> {
	protected TNode<E> root;
	protected int size;
	
	/**
	 * Instancia un objeto de tipo LinkedTree, el nuevo objeto es un árbol vacío.
	 */
	public LinkedTree(){ size = 0; root = null; }

	@Override
	public int size(){ return size; }

	@Override
	public boolean isEmpty(){ return size == 0; }
	
	/**
	 * Revisa si la posición pasada por parámetro es válida, es decir, si no es nula
	 * y es una instancia de TNode. También chequea si el árbol está vacío. Luego, 
	 * devuelve el nodo correspondiente a la posición pasada por parámetro.
	 * @param p Posición a revisar.
	 * @return Nodo de la posición.
	 * @throws InvalidPositionException si la posición es nula o no es instancia de TNodo, o si el árbol está vacío.
	 */
	private TNode<E> checkPosition(Position<E> p) throws InvalidPositionException {
		if(size == 0) throw new InvalidPositionException("Tree is empty");
		if(p == null) throw new InvalidPositionException("Position is null");
		try {
			return (TNode<E>) p;
		} catch(ClassCastException e){
			throw new InvalidPositionException("Invalid position, it isn't a proper node");
		}
	}	
	
	private void preorder(PositionList<Position<E>> l, TNode<E> p){
		l.addLast(p);
		for(TNode<E> c : p.getChildren()) preorder(l,c);
	}

	@Override
	public Iterator<E> iterator() {
		PositionList<E> l = new DoublyLinkedList<E>();
		for(Position<E> e : positions()) l.addLast(e.element()); 
		return l.iterator();
	}

	@Override
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> l = new DoublyLinkedList<Position<E>>();
		if(root != null) preorder(l,root);
		return l;
	}

	@Override
	public E replace(Position<E> p, E e) throws InvalidPositionException {
		TNode<E> n = checkPosition(p);
		E tmp = n.element();
		n.setElement(e);
		return tmp;
	}

	@Override
	public Position<E> root() throws EmptyTreeException {
		if(size == 0) throw new EmptyTreeException("Tree is empty");
		return root;
	}

	@Override
	public Position<E> parent(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		TNode<E> n = checkPosition(p);
		if(n == root) throw new BoundaryViolationException("The position has't parent, it's the root");
		return n.getParent();
	}

	@Override
	public Iterable<Position<E>> children(Position<E> p) throws InvalidPositionException {
		TNode<E> n = checkPosition(p);
		PositionList<Position<E>> l = new DoublyLinkedList<Position<E>>();
		for(TNode<E> x : n.getChildren()) l.addLast(x);
		return l;
	}

	@Override
	public boolean isInternal(Position<E> p) throws InvalidPositionException {
		TNode<E> n = checkPosition(p);
		return !n.getChildren().isEmpty();
	}

	@Override
	public boolean isExternal(Position<E> p) throws InvalidPositionException {
		TNode<E> n = checkPosition(p);
		return n.getChildren().isEmpty();
	}

	@Override
	public boolean isRoot(Position<E> p) throws InvalidPositionException {
		TNode<E> n = checkPosition(p);
		return n == root;
	}

	@Override
	public void createRoot(E e) throws InvalidOperationException {
		if(root != null) throw new InvalidOperationException("There's a root already");
		root = new TNode<E>(e);
		size++;
	}

	@Override
	public Position<E> addFirstChild(Position<E> p, E e) throws InvalidPositionException {
		TNode<E> n = checkPosition(p);
		TNode<E> newChild = new TNode<E>(e,n);
		n.getChildren().addFirst(newChild);
		size++;
		return newChild;
	}

	@Override
	public Position<E> addLastChild(Position<E> p, E e) throws InvalidPositionException {
		TNode<E> n = checkPosition(p);
		TNode<E> newChild = new TNode<E>(e,n);
		n.getChildren().addLast(newChild);
		size++;
		return newChild;
	}

	@Override
	public Position<E> addBefore(Position<E> p, Position<E> rb, E e) throws InvalidPositionException {
		TNode<E> n = checkPosition(p), prb = checkPosition(rb), newChild = new TNode<E>(e,n);
		for(TDALista.Position<TNode<E>> x : n.getChildren().positions()){
			if(x.element() == prb){
				try {
					n.getChildren().addBefore(x,newChild);
					size++;
					return newChild;
				} catch (TDALista.InvalidPositionException exc) {
					throw new InvalidPositionException(exc.getMessage());
				}
			}
		}
		throw new InvalidPositionException("p is not parent of rb");
	}

	@Override
	public Position<E> addAfter(Position<E> p, Position<E> lb, E e) throws InvalidPositionException {
		TNode<E> n = checkPosition(p), plb = checkPosition(lb), newChild = new TNode<E>(e,n);
		for(TDALista.Position<TNode<E>> x : n.getChildren().positions()){
			if(x.element() == plb){
				try {
					n.getChildren().addAfter(x,newChild);
					size++;
					return newChild;
				} catch (TDALista.InvalidPositionException exc) {
					throw new InvalidPositionException(exc.getMessage());
				}
			}
		}
		throw new InvalidPositionException("p is not parent of lb");
	}

	@Override
	public void removeExternalNode(Position<E> p) throws InvalidPositionException {
		if(isInternal(p)) throw new InvalidPositionException("Position isn't an external node");
		TNode<E> n = checkPosition(p);
		if(n == root){
			root = null; size--;
			return;
		}
		TNode<E> parent = n.getParent();
		for(TDALista.Position<TNode<E>> x : parent.getChildren().positions()){
			if(x.element() == n){
				try {
					parent.getChildren().remove(x);
					size--;
					return;
				} catch (TDALista.InvalidPositionException exc) {
					throw new InvalidPositionException(exc.getMessage());			
				}
			}
		}
		throw new InvalidPositionException("Position doesn't belong to the tree");
	}

	@Override
	public void removeInternalNode(Position<E> p) throws InvalidPositionException {
		if(isExternal(p)) throw new InvalidPositionException("Position isn't an internal node");
		TNode<E> n = checkPosition(p);
		if(n == root){
			if(n.getChildren().size() > 1) 
				throw new InvalidPositionException("Root can't be removed when it has more than one child"); 
			else {
				try {
					root = n.getChildren().first().element();
					root.setParent(null);
					size--;
					return;
				} catch (EmptyListException exc) {
					throw new InvalidPositionException(exc.getMessage());
				}
			}
		}
		TNode<E> parent = n.getParent();
		PositionList<TNode<E>> children = parent.getChildren();
		for(TDALista.Position<TNode<E>> x : children.positions()){
			if(x.element() == n){
				try {
					TDALista.Position<TNode<E>> prev = x;
					for(TNode<E> y : n.getChildren()){
						y.setParent(parent);
						children.addAfter(prev,y);
						prev = children.next(prev);
					}
					children.remove(x);
					size--;
					return;
				} catch (TDALista.InvalidPositionException | TDALista.BoundaryViolationException exc) {
					throw new InvalidPositionException(exc.getMessage());			
				}
			}
		}
		throw new InvalidPositionException("Position doesn't belong to the tree");
	}

	@Override
	public void removeNode(Position<E> p) throws InvalidPositionException {
		if(isExternal(p)) removeExternalNode(p);
		else removeInternalNode(p);
	}
}

package TDAPila;

/**
 * Class ArrayStack.
 * Implementa Stack. 
 * Representa una pila con arreglo de crecimiento dinámico.
 *
 * @param <E> Tipo de los elementos almacenados.
 */
public class ArrayStack<E> implements Stack<E>{
	protected int size;
	protected E[] data;

	/**
	 * Crea una pila vacía.
	 */
	public ArrayStack(){
		size = 0;
		data = (E[]) new Object[1];
	}
	
	@Override
	public int size(){ return size;	}
	
	@Override
	public boolean isEmpty(){ return size == 0; }
	
	@Override
	public E top() throws EmptyStackException{
		if(size == 0) throw new EmptyStackException("Stack is empty");
		return data[size-1];
	}
	
	@Override
	public void push(E elem){
		int cap = data.length;
		if(size == cap){
			E[] newData = (E[]) new Object[cap*2];
			for(int i = 0; i < size; i++) 
				newData[i] = data[i];
			data = newData;	
		}
		data[size++] = elem;
	}
	
	@Override
	public E pop() throws EmptyStackException{
		if(size == 0) throw new EmptyStackException("Stack is empty");
		E aux = data[size-1];
		data[--size] = null;
		int cap = data.length;
		if(size == cap/4){
			E[] newData = (E[]) new Object[cap/2];
			for(int i = 0; i < size; i++)
				newData[i] = data[i];
			data = newData;
		}
		return aux;
	}
}

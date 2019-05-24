package TDAPila;

public class ArrayStack<E> implements Stack<E>{
	protected int size;
	protected E[] data;

	public ArrayStack(){
		size = 0;
		data = (E[]) new Object[1];
	}
	
	public int size(){ return size;	}
	
	public boolean isEmpty(){ return size == 0; }
	
	public E top() throws EmptyStackException{
		if(size == 0) throw new EmptyStackException("Empty stack while getting top");
		return data[size-1];
	}
	
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
	
	public E pop() throws EmptyStackException{
		if(size == 0) throw new EmptyStackException("Empty stack while popping");
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

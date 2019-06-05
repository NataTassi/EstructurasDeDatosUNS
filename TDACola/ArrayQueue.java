package TDACola;

/**
 * Class ArrayQueue.
 * Implementa Queue. 
 * Representa una cola circular con arreglo de crecimiento dinámico.
 *
 * @param <E> Tipo de los elementos almacenados.
 */
public class ArrayQueue<E> implements Queue<E> {
	protected int f,r,n;
	protected E[] data;
	
	/**
	 * Crea una cola vacía.
	 */
	public ArrayQueue(){
		n = 2; f = r = 0;
		data = (E[]) new Object[n];
	}
	
	@Override
	public void enqueue(E elem){
        int sz = size();
		if(sz == n-1){
		    E[] newData = (E[]) new Object[2*n];
            for(int i = 0; i < sz; i++) newData[i] = data[(f+i) % n];
            f = 0; r = sz; n *= 2;
            data = newData;
        }
		data[r] = elem;
		r = (r+1) % n;
	}
	
	@Override
	public E dequeue() throws EmptyQueueException{
		if(isEmpty()) throw new EmptyQueueException("Queue is empty");
		E tmp = data[f];
		data[f] = null;
		f = (f+1) % n;
        int sz = size();
        if(sz == n/4){
		    E[] newData = (E[]) new Object[n/2];
            for(int i = 0; i < sz; i++) newData[i] = data[(f+i) % n];
            f = 0; r = sz; n /= 2;
            data = newData;
        }
		return tmp;
	}
	
	@Override
	public E front() throws EmptyQueueException{
		if(isEmpty()) throw new EmptyQueueException("Queue is empty");
		return data[f];
	}
	
	@Override
	public boolean isEmpty(){ return f == r; }
	
	@Override
	public int size(){ return (r-f+n) % n; }
}

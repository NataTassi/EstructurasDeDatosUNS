package TDAMapeo;
import TDALista.*;

/**
 * Class OpenHashMap.
 * Implementa Map.
 * Representa un mapeo para almacenar pares clave-valor con una tabla hash abierta.
 * 
 * @param <K> Tipo de las claves de las entradas del mapeo.
 * @param <V> Tipo de los valores de las entradas del mapeo.
 */
public class OpenHashMap<K,V> implements Map<K,V> {
	protected static double loadfactor = 0.9;
	protected PositionList<MEntry<K,V>>[] buckets;
	protected int size,cap;
	
	/**
	 * Crea un mapeo con una tabla de cubetas de tama�o adecuado para la cantidad m�nima de entradas esperadas.
	 * @param x Cantidad de entradas que se espera introducir.
	 */
	public OpenHashMap(int x){
		cap = nextPrime(x); size = 0;
		buckets = (PositionList<MEntry<K,V>>[]) new DoublyLinkedList[cap];
		for(int i = 0; i < cap; i++)
			buckets[i] = new DoublyLinkedList<MEntry<K,V>>();
	}
	/**
	 * Crea un mapeo sin conococimiento de la cantidad de entradas a introducirse.
	 */
	public OpenHashMap(){ this(13); }
	
	/**
	 * Establece el factor de carga de la tabla de cubetas del mapeo.
	 * @param l Nuevo factor de carga.
	 */
	public void setLoadFactor(double l){ loadfactor = l; }
	
	/**
	 * Retorna el siguiente primo mayor o igual al n�mero dado.
	 * @param x Un n�mero entero positivo.
	 * @return Siguiente primo mayor o igual al n�mero dado.
	 */
	private int nextPrime(int x){
		if(x < 2) return 2;
		for(int i = 2; i*i <= x; i++)
			if(x % i == 0) return nextPrime(x+1);
		return x;
	}
	
	/**
	 * Devuelve un c�digo hash para la clave pasada como par�metro de tipo entero positivo.
	 * @param k Clave.
	 * @return C�digo hash.
	 */
	private int h(K k){ return Math.abs(k.hashCode()); }
	
	@Override
	public int size() { return size; }

	@Override
	public boolean isEmpty() { return size == 0; }

	@Override
	public V get(K k) throws InvalidKeyException {
		if(k == null) throw new InvalidKeyException("Key is null");
		for(MEntry<K,V> e : buckets[h(k) % cap])
			if(e.getKey().equals(k)) return e.getValue();
 		return null;
	}
	
	/**
	 * Incrementa el tama�o de la tabla de cubetas al doble del siguiente primo de la capacidad actual.
	 */
	private void increaseTable() {
		int newCap = nextPrime(2*cap);
		PositionList<MEntry<K,V>>[] newBuckets = (PositionList<MEntry<K,V>>[]) new DoublyLinkedList[newCap];
		for(int i = 0; i < newCap; i++) newBuckets[i] = new DoublyLinkedList<MEntry<K,V>>();
		
		for(int i = 0; i < cap; i++){
			for(MEntry<K,V> e : buckets[i]){
				int loc = h(e.getKey()) % newCap;
				newBuckets[loc].addLast(e);
			}
		}
		cap = newCap; buckets = newBuckets;
	}
	
	@Override
	public V put(K k, V v) throws InvalidKeyException {
		if(k == null) throw new InvalidKeyException("Key is null");
		for(MEntry<K,V> e : buckets[h(k) % cap]){
			if(e.getKey().equals(k)){
				V tmp = e.getValue();
				e.setValue(v);
				return tmp;
			}
		}
		size++;
		if((double)size/cap >= loadfactor) increaseTable();
		buckets[h(k) % cap].addLast(new MEntry<K,V>(k,v)); 
		return null;
	}

	@Override
	public V remove(K k) throws InvalidKeyException {
		if(k == null) throw new InvalidKeyException("Key is null");
		int loc = h(k) % cap;
		try{ 
			for(Position<MEntry<K,V>> e : buckets[loc].positions()){
				if(e.element().getKey().equals(k)){
					size--;
					V tmp = e.element().getValue(); 
					buckets[loc].remove(e);
					return tmp;
				}
			}
		} catch(InvalidPositionException exc){
			System.out.println(exc + "\n" + exc.getStackTrace());
		}
		return null;
	}

	@Override
	public Iterable<K> keys() {
		PositionList<K> l = new DoublyLinkedList<K>();
		for(int i = 0; i < cap; i++) 
			for(MEntry<K,V> e : buckets[i]) 
				l.addLast(e.getKey());
		return l;
	}

	@Override
	public Iterable<V> values() {
		PositionList<V> l = new DoublyLinkedList<V>();
		for(int i = 0; i < cap; i++) 
			for(MEntry<K,V> e : buckets[i]) 
				l.addLast(e.getValue());
		return l;
	}

	@Override
	public Iterable<Entry<K, V>> entries() {
		PositionList<Entry<K,V>> l = new DoublyLinkedList<Entry<K,V>>();
		for(int i = 0; i < cap; i++) 
			for(MEntry<K,V> e : buckets[i]) l.addLast(e);
		return l;
	}
}

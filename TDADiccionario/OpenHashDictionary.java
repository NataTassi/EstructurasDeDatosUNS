package TDADiccionario;
import TDALista.*;

/**
 * Class OpenHashDictionary.
 * Implementa Dictionary.
 * Representa un diccionario para almacenar pares clave-valor con una tabla hash abierta.
 * 
 * @param <K> Tipo de las claves de las entradas del diccionario.
 * @param <V> Tipo de los valores de las entradas del diccionario.
 */
public class OpenHashDictionary<K,V> implements Dictionary<K,V> {
	protected static double loadfactor = 0.9;
	protected PositionList<DEntry<K,V>>[] buckets;
	protected int size,cap;
	
	/**
	 * Instancia un objeto de tipo OpenHashDictionary.
	 * @param x Cantidad de entradas mínimas a introducirse.
	 */
	public OpenHashDictionary(int x){
		cap = nextPrime(x); size = 0;
		buckets = (PositionList<DEntry<K,V>>[]) new DoublyLinkedList[cap];
		for(int i = 0; i < cap; i++)
			buckets[i] = new DoublyLinkedList<DEntry<K,V>>();
	}
	/**
	 * Instancia un objeto de tipo OpenHashDictionary.
	 */
	public OpenHashDictionary(){ this(13); }
	
	/**
	 * Establece el factor de carga de la tabla de cubetas del diccionario.
	 * @param l Nuevo factor de carga.
	 */
	public void setLoadFactor(double l){ loadfactor = l; }
	
	/**
	 * Retorna el siguiente primo mayor o igual al número dado.
	 * @param x Un número entero positivo.
	 * @return Siguiente primo mayor o igual al número dado.
	 */
	private int nextPrime(int x){
		if(x < 2) return 2;
		for(int i = 2; i*i <= x; i++)
			if(x % i == 0) return nextPrime(x+1);
		return x;
	}
	
	/**
	 * Devuelve un código hash para la clave pasada como parámetro de tipo entero positivo.
	 * @param k Clave.
	 * @return Código hash.
	 */
	private int h(K k){ return Math.abs(k.hashCode()); }

	@Override
	public int size() { return size; }

	@Override
	public boolean isEmpty() { return size == 0; }

	@Override
	public Entry<K,V> find(K k) throws InvalidKeyException {
		if(k == null) throw new InvalidKeyException("Key is null");
		for(Entry<K,V> e : buckets[h(k) % cap])
			if(e.getKey().equals(k)) return e;
		return null;
	}

	@Override
	public Iterable<Entry<K,V>> findAll(K k) throws InvalidKeyException {
		if(k == null) throw new InvalidKeyException("Key is null");
		PositionList<Entry<K,V>> l = new DoublyLinkedList<Entry<K,V>>();
		for(Entry<K,V> e : buckets[h(k) % cap])
			if(e.getKey().equals(k)) l.addLast(e);
		return l;
	}
	
	/**
	 * Incrementa el tamaño de la tabla de cubetas al doble del siguiente primo de la capacidad actual.
	 */
	private void increaseTable() {
		int newCap = nextPrime(2*cap);
		PositionList<DEntry<K,V>>[] newBuckets = (PositionList<DEntry<K,V>>[]) new DoublyLinkedList[newCap];
		for(int i = 0; i < newCap; i++) newBuckets[i] = new DoublyLinkedList<DEntry<K,V>>();
		
		for(int i = 0; i < cap; i++){
			for(DEntry<K,V> e : buckets[i]){
				int loc = h(e.getKey()) % newCap;
				newBuckets[loc].addLast(e);
			}
		}
		cap = newCap; buckets = newBuckets;
	}

	@Override
	public Entry<K,V> insert(K k, V v) throws InvalidKeyException {
		if(k == null) throw new InvalidKeyException("Key is null");
		DEntry<K,V> e = new DEntry<K,V>(k,v);
		size++;
		if((double)size/cap >= loadfactor) increaseTable();
		buckets[h(k) % cap].addLast(e);
		return e;
	}

	@Override
	public Entry<K,V> remove(Entry<K,V> e) throws InvalidEntryException {
		if(e == null) throw new InvalidEntryException("Entry is null");
		try {
			int loc = h(e.getKey()) % cap;
			for(Position<DEntry<K,V>> x : buckets[loc].positions())
				if(e == x.element()) {
					size--;
					return buckets[loc].remove(x);
				}
		} catch(InvalidPositionException exc){
			System.out.println(exc + "\n" + exc.getStackTrace());
		} 
		throw new InvalidEntryException("There's no such entry");
	}

	@Override
	public Iterable<Entry<K,V>> entries() {
		PositionList<Entry<K,V>> l = new DoublyLinkedList<Entry<K,V>>();
		for(int i = 0; i < cap; i++) 
			for(Entry<K,V> e : buckets[i]) l.addLast(e);
		return l;
	}
}

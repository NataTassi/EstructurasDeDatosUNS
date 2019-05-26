package TDAMapeo;
import TDALista.*;

/**
 * Class CloseHashMap.
 * Implementa Map.
 * Representa un mapeo para almacenar pares clave-valor con una tabla hash cerrada 
 * que adopta la política de resolución lineal de colisiones.
 * 
 * @param <K> Tipo de las claves de las entradas del mapeo.
 * @param <V> Tipo de los valores de las entradas del mapeo.
 */
public class CloseHashMap<K,V> implements Map<K,V> {
	protected static double loadfactor = 0.5;
	protected MEntry<K,V> free,buckets[];
	protected int size,cap;
	
	/**
	 * Instancia un objeto de tipo CloseHashMap.
	 * @param x Cantidad de entradas mínimas a introducirse.
	 */
	public CloseHashMap(int x) {
		cap = nextPrime(x); size = 0; free = new MEntry<K,V>();
		buckets = (MEntry<K,V>[]) new MEntry[cap];
		for(int i = 0; i < cap; i++) buckets[i] = null;
	}
	/**
	 * Instancia un objeto de tipo CloseHashMap.
	 */
	public CloseHashMap(){ this(13); }
	
	/**
	 * Establece el factor de carga de la tabla de cubetas del mapeo.
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
	public V get(K k) throws InvalidKeyException {
		if(k == null) throw new InvalidKeyException("Key is null");
		int loc = h(k) % cap;
		boolean is = true;
		for(int i = 0; is && i < cap; i++){
			int j = (loc+i) % cap;
			if(buckets[j] == null) is = false;
			else if(buckets[j] == free) continue;
			else if(buckets[j].getKey().equals(k)) return buckets[j].getValue();
		}
		return null;
	}
	
	/**
	 * Incrementa el tamaño de la tabla de cubetas al doble del siguiente primo de la capacidad actual.
	 */
	private void increaseTable() {
		int newCap = nextPrime(2*cap);
		MEntry<K,V>[] newBuckets = (MEntry<K,V>[]) new MEntry[newCap];
		for(int i = 0; i < newCap; i++) newBuckets[i] = null;
		
		for(int i = 0; i < cap; i++){
			if(buckets[i] != null && buckets[i] != free){
				int loc = h(buckets[i].getKey()) % newCap;
				boolean set = false;
				for(int j = 0; !set && j < newCap; j++){
					int k = (loc+j) % newCap;
					if(newBuckets[k] == null){
						newBuckets[k] = buckets[i]; 
						set = true;
					} 
				}
			}
		}
		cap = newCap; buckets = newBuckets;
	}
	
	@Override
	public V put(K k, V v) throws InvalidKeyException {
		if(k == null) throw new InvalidKeyException("Key is null");
		int loc = h(k) % cap, firstFree = -1;
		boolean set = false;
		for(int i = 0; !set && i < cap; i++){
			int j = (loc+i) % cap;
			if(buckets[j] == free){
				if(firstFree == -1) firstFree = j;
			} else if(buckets[j] == null){
				buckets[firstFree != -1 ? firstFree : j] = new MEntry<K,V>(k,v);
				size++;
				if((double)size/cap > loadfactor) increaseTable();
				set = true;
			} else if(buckets[j].getKey().equals(k)){
				V tmp = buckets[j].getValue();
				buckets[j].setValue(v);
				return tmp;
			}
		}
		return null;
	}

	@Override
	public V remove(K k) throws InvalidKeyException {
		if(k == null) throw new InvalidKeyException("Key is null");
		int loc = h(k) % cap;
		boolean is = true;
		for(int i = 0; is && i < cap; i++){
			int j = (loc+i) % cap;
			if(buckets[j] == null) is = false;
			else if(buckets[j] == free) continue;
			else if(buckets[j].getKey().equals(k)) {
				size--;
				V tmp = buckets[j].getValue();
				buckets[j] = free;
				return tmp;
			}
		}
		return null;
	}

	@Override
	public Iterable<K> keys() {
		PositionList<K> l = new DoublyLinkedList<K>();
		for(int i = 0; i < cap; i++) 
			if(buckets[i] != null && buckets[i] != free) 
				l.addLast(buckets[i].getKey());
		return l;
	}

	@Override
	public Iterable<V> values() {
		PositionList<V> l = new DoublyLinkedList<V>();
		for(int i = 0; i < cap; i++) 
			if(buckets[i] != null && buckets[i] != free) 
				l.addLast(buckets[i].getValue());
		return l;
	}

	@Override
	public Iterable<Entry<K,V>> entries() {
		PositionList<Entry<K,V>> l = new DoublyLinkedList<Entry<K,V>>();
		for(int i = 0; i < cap; i++) 
			if(buckets[i] != null && buckets[i] != free) 
				l.addLast(buckets[i]);
		return l;
	}
}

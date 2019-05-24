package TDAMapeo;
import TDALista.*;

public class OpenHashMap<K,V> implements Map<K,V> {
	protected static final double loadfactor = 0.9;
	protected PositionList<MEntry<K,V>>[] buckets;
	protected int size,cap;
	
	public OpenHashMap(){ this(13); }
	public OpenHashMap(int x){
		cap = nextPrime(x); size = 0;
		buckets = (PositionList<MEntry<K,V>>[]) new DoublyLinkedList[cap];
		for(int i = 0; i < cap; i++)
			buckets[i] = new DoublyLinkedList<MEntry<K,V>>();
	}
	
	private int nextPrime(int x){
		for(int i = 2; i*i <= x; i++)
			if(x % i == 0) return nextPrime(x+1);
		return x;
	}
	
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
	
	private void increaseTable() {
		int newCap = nextPrime(2*cap);
		PositionList<MEntry<K,V>>[] newBuckets = (PositionList<MEntry<K,V>>[]) new DoublyLinkedList[newCap];
		for(int i = 0; i < newCap; i++)
			newBuckets[i] = new DoublyLinkedList<MEntry<K,V>>();
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
		if((double)size/cap > loadfactor) increaseTable();
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
			for(MEntry<K,V> e : buckets[i]) 
				l.addLast(e);
		return l;
	}
}

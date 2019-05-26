package TDAMapeo;
import TDALista.*;

public class ListMap<K,V> implements Map<K,V> {
	protected PositionList<MEntry<K,V>> m;

	public ListMap(){ m = new DoublyLinkedList<MEntry<K,V>>(); }
	
	@Override
	public int size(){ return m.size(); }

	@Override
	public boolean isEmpty(){ return m.size() == 0;	}

	@Override
	public V get(K k) throws InvalidKeyException {
		if(k == null) throw new InvalidKeyException("Key is null");
		for(MEntry<K,V> e : m) if(e.getKey().equals(k))
			return e.getValue();
		return null;
	}

	@Override
	public V put(K k, V v) throws InvalidKeyException {
		if(k == null) throw new InvalidKeyException("Key is null");
		for(MEntry<K,V> e : m) if(e.getKey().equals(k)){
			V tmp = e.getValue();
			e.setValue(v);
			return tmp;
		}
		m.addLast(new MEntry<K,V>(k,v));
		return null;
	}

	@Override
	public V remove(K k) throws InvalidKeyException {
		if(k == null) throw new InvalidKeyException("Key is null");
		try{ 
			for(Position<MEntry<K,V>> e : m.positions()){
				if(e.element().getKey().equals(k)){
					V tmp = e.element().getValue();
					m.remove(e);
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
		for(MEntry<K,V> e : m) l.addLast(e.getKey());
		return l;
	}

	@Override
	public Iterable<V> values() {
		PositionList<V> l = new DoublyLinkedList<V>();
		for(MEntry<K,V> e : m) l.addLast(e.getValue());
		return l;
	}

	@Override
	public Iterable<Entry<K,V>> entries() {
		PositionList<Entry<K,V>> l = new DoublyLinkedList<Entry<K,V>>();
		for(MEntry<K,V> e : m) l.addLast(e);
		return l;
	}
}

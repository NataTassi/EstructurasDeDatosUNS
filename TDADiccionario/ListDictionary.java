package TDADiccionario;
import TDALista.*;

public class ListDictionary<K,V> implements Dictionary<K,V> {
	protected DoublyLinkedList<Entry<K,V>> m;
	
	public ListDictionary(){ m = new DoublyLinkedList<Entry<K,V>>(); }
	
	@Override
	public int size() { return m.size(); }

	@Override
	public boolean isEmpty() { return m.size() == 0; }

	@Override
	public Entry<K,V> find(K k) throws InvalidKeyException {
		if(k == null) throw new InvalidKeyException("Key is null");
		for(Entry<K,V> e : m) if(e.getKey().equals(k)) return e;
		return null;
	}

	@Override
	public Iterable<Entry<K,V>> findAll(K k) throws InvalidKeyException {
		if(k == null) throw new InvalidKeyException("Key is null");
		PositionList<Entry<K,V>> l = new DoublyLinkedList<Entry<K,V>>();
		for(Entry<K,V> e : m) if(e.getKey().equals(k)) l.addLast(e);
		return l;
	}

	@Override
	public Entry<K,V> insert(K k, V v) throws InvalidKeyException {
		if(k == null) throw new InvalidKeyException("Key is null");
		Entry<K,V> newEntry = new DEntry<K,V>(k,v);
 		m.addLast(newEntry);
		return newEntry;
	}

	@Override
	public Entry<K,V> remove(Entry<K,V> e) throws InvalidEntryException {
		if(e == null) throw new InvalidEntryException("Entry is null");
		try {
			for(Position<Entry<K,V>> x : m.positions()) 
				if(x.element() == e) return m.remove(x);
		} catch (InvalidPositionException exc) {
			System.out.println(exc + "\n" + exc.getStackTrace());
		}
		throw new InvalidEntryException("There's no such entry");
	}

	@Override
	public Iterable<Entry<K,V>> entries() { return m; }

}

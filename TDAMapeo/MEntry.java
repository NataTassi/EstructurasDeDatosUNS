package TDAMapeo;

public class MEntry<K,V> implements Entry<K,V>{
	protected K key;
	protected V val;
	
	public MEntry(K k, V v){ key = k; val = v; }
	public MEntry(){ this(null,null); }
	
	public K getKey(){ return key; }
	public V getValue(){ return val; }
	
	public void setKey(K k){ key = k; }
	public void setValue(V v){ val = v; }
	
	public String toString(){ return "(" + key + "," + val + ")"; }
}
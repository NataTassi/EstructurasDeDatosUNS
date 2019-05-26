package TDAMapeo;

/**
 * Class MEntry.
 * Implementa Entry.
 * Representa una entrada en CloseHashMap.
 *
 * @param <K> Tipo de la clave de MEntry.
 * @param <V> Tipo del valor de MEntry.
 */
public class MEntry<K,V> implements Entry<K,V>{
	protected K key;
	protected V val;
	
    /**
     * Instancia un objeto de tipo MEntry y establece su clave y su valor.
     * @param k Clave de MEntry.
     * @param v Valor de MEntry.
     */
	public MEntry(K k, V v){ key = k; val = v; }
    /**
     * Instancia un objeto de tipo MEntry con todas sus referencias nulas.
     */
	public MEntry(){ this(null,null); }
	
	@Override
	public K getKey(){ return key; }
	
	@Override
	public V getValue(){ return val; }
	
	/**
	 * Establece la clave de la entrada.
	 * @param k clave.
	 */
	public void setKey(K k){ key = k; }
	
	/**
	 * Establece el valor de la entrada.
	 * @param v Nuevo valor.
	 */
	public void setValue(V v){ val = v; }
	
	@Override
	public String toString(){ return "(" + key + "," + val + ")"; }
}
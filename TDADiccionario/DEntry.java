package TDADiccionario;

/**
 * Class DEntry
 * Implementa Entry.
 * Representa una entrada en OpenHashDictionary.
 *
 * @param <K> Tipo de la clave de DEntry.
 * @param <V> Tipo del valor de DEntry.
 */
public class DEntry<K,V> implements Entry<K,V>{
	protected K key;
	protected V val;
	
    /**
     * Instancia un objeto de tipo DEntry y establece su clave y su valor.
     * @param k Clave de DEntry.
     * @param v Valor de DEntry.
     */
	public DEntry(K k, V v){ key = k; val = v; }
    /**
     * Instancia un objeto de tipo DEntry con todas sus referencias nulas.
     */
	public DEntry(){ this(null,null); }
	
	@Override
	public K getKey(){ return key; }
	
	@Override
	public V getValue(){ return val; }
	
	/**
	 * Establece la clave de la entrada.
	 * @param k Nueva clave.
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
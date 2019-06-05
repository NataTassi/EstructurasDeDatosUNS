package TDADiccionario;

/**
 * Class DEntry
 * Implementa Entry.
 * Representa una entrada en OpenHashDictionary.
 *
 * @param <K> Tipo de las claves de las entradas del diccionario.
 * @param <V> Tipo del los valores de las entradas del diccionario.
 */
public class DEntry<K,V> implements Entry<K,V>{
	protected K key;
	protected V val;
	
    /**
     * Crea una entrada con la clave y valor dados.
     * @param k Clave.
     * @param v Valor.
     */
	public DEntry(K k, V v){ key = k; val = v; }
    /**
     * Crea una entrada con todas sus referencias nulas.
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
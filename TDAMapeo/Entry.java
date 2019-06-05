package TDAMapeo;

/**
 * Interface Entry.
 * Representa una entrada en un mapeo con un par clave-valor. 
 * 
 * @param <K> Tipo de las claves de las entradas del mapeo.
 * @param <V> Tipo del los valores de las entradas del mapeo. 
 */
public interface Entry<K,V>{
	/**
	 * Retorna la clave de la entrada.
	 * @return Clave de la entrada.
	 */
    public K getKey();
    /**
     * Retorna el valor de la entrada.
     * @return Valor de la entrada.
     */
    public V getValue();
}
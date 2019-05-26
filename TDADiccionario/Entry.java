package TDADiccionario;

/**
 * Interface Entry.
 * Representa una entrada en un diccionario con un par clave-valor. 
 * 
 * @param <K> Tipo de la clave.
 * @param <V> Tipo del valor.
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
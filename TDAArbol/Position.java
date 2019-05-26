package TDAArbol;

/**
 * Interface Position.
 * Representa la ubicaci�n de un elemento en una estructura de datos con enlaces.
 * 
 * @param <E> Tipo de los elementos que almacena la estructura de la posici�n.
 */
public interface Position<E> {
	/**
	 * Retorna el valor del elemento ubicado en la posici�n.
	 * @return el valor del elemento ubicado en la posici�n.
	 */
	public E element();
}
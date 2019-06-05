package TDALista;

/**
 * Class EmptyListException.
 * Modela la excepción ante una lista vacía.
 */
public class EmptyListException extends Exception{
    /**
	 * @param msg Mensaje que describe el evento que disparó la excepción.
	 */
    public EmptyListException(String msg){ super(msg); }
}
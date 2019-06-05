package TDALista;

/**
 * Class EmptyListException.
 * Modela la excepci�n ante una lista vac�a.
 */
public class EmptyListException extends Exception{
    /**
	 * @param msg Mensaje que describe el evento que dispar� la excepci�n.
	 */
    public EmptyListException(String msg){ super(msg); }
}
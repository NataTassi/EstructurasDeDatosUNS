package TDAArbol;

/**
 * Class EmptyTreeException.
 * Modela la excepci�n ante un �rbol vac�o.
 */
public class EmptyTreeException extends Exception{
    /**
	 * @param msg Mensaje que describe el evento que dispar� la excepci�n.
	 */
    public EmptyTreeException(String msg){ super(msg); }
}

package TDAArbol;

/**
 * Class EmptyTreeException.
 * Modela la excepción ante un árbol vacío.
 */
public class EmptyTreeException extends Exception{
    /**
	 * @param msg Mensaje que describe el evento que disparó la excepción.
	 */
    public EmptyTreeException(String msg){ super(msg); }
}

package TDAArbol;

/**
 * Class InvalidOperationException.
 * Modela la excepción ante el intento de una operación inválida.
 */
public class InvalidOperationException extends Exception{
    /**
	 * @param msg Mensaje que describe el evento que disparó la excepción.
	 */
    public InvalidOperationException(String msg){ super(msg); }
}

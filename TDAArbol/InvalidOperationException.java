package TDAArbol;

/**
 * Class InvalidOperationException.
 * Modela la excepci�n ante el intento de una operaci�n inv�lida.
 */
public class InvalidOperationException extends Exception{
    /**
	 * @param msg Mensaje que describe el evento que dispar� la excepci�n.
	 */
    public InvalidOperationException(String msg){ super(msg); }
}

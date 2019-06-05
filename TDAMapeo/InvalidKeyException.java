package TDAMapeo;

/**
 * Class InvalidKeyException.
 * Modela la excepci�n ante una entrada pasada inv�lida.
 */
public class InvalidKeyException extends Exception{
    /**
	 * @param msg Mensaje que describe el evento que dispar� la excepci�n.
	 */
    public InvalidKeyException(String msg){ super(msg); }
}
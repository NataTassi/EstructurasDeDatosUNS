package TDAMapeo;

/**
 * Class InvalidKeyException.
 * Modela la excepción ante una entrada pasada inválida.
 */
public class InvalidKeyException extends Exception{
    /**
	 * @param msg Mensaje que describe el evento que disparó la excepción.
	 */
    public InvalidKeyException(String msg){ super(msg); }
}
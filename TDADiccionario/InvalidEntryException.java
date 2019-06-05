package TDADiccionario;

/**
 * Class InvalidEntryException.
 * Modela la excepción ante una entrada pasada inválida.
 */
public class InvalidEntryException extends Exception{
    /**
	 * @param msg Mensaje que describe el evento que disparó la excepción.
	 */
    public InvalidEntryException(String msg){ super(msg); }
}
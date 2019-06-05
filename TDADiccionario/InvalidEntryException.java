package TDADiccionario;

/**
 * Class InvalidEntryException.
 * Modela la excepci�n ante una entrada pasada inv�lida.
 */
public class InvalidEntryException extends Exception{
    /**
	 * @param msg Mensaje que describe el evento que dispar� la excepci�n.
	 */
    public InvalidEntryException(String msg){ super(msg); }
}
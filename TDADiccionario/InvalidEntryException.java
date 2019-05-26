package TDADiccionario;

/**
 * Class InvalidEntryException.
 * Extiende Exception.
 */
public class InvalidEntryException extends Exception{
    /**
	 * Instancia un objeto de tipo InvalidEntryException.
	 * @param msg Mensaje que describe el evento que dispar� la excepci�n.
	 */
    public InvalidEntryException(String msg){
        super(msg);
    }
}
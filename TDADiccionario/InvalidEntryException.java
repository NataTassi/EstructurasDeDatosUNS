package TDADiccionario;

/**
 * Class InvalidEntryException.
 * Extiende Exception.
 */
public class InvalidEntryException extends Exception{
    /**
	 * Instancia un objeto de tipo InvalidEntryException.
	 * @param msg Mensaje que describe el evento que disparó la excepción.
	 */
    public InvalidEntryException(String msg){
        super(msg);
    }
}
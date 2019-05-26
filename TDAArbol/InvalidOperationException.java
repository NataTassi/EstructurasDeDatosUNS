package TDAArbol;

/**
 * Class InvalidOperationException.
 * Extiende Exception.
 */
public class InvalidOperationException extends Exception{
    /**
	 * Instancia un objeto de tipo InvalidOperationException.
	 * @param msg Mensaje que describe el evento que dispar� la excepci�n.
	 */
    public InvalidOperationException(String msg){
        super(msg);
    }
}

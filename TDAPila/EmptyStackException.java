package TDAPila;

/**
 * Class EmptyStackException.
 * Extiende Exception.
 */
public class EmptyStackException extends Exception{
    /**
	 * Instancia un objeto de tipo EmptyStackException.
	 * @param msg Mensaje que describe el evento que dispar� la excepci�n.
	 */
    public EmptyStackException(String msg){
    	super(msg);
    }
}
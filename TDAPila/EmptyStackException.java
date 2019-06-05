package TDAPila;

/**
 * Class EmptyStackException.
 * Modela la excepci�n ante una pila vac�a.
 */
public class EmptyStackException extends Exception{
    /**
	 * @param msg Mensaje que describe el evento que dispar� la excepci�n.
	 */
    public EmptyStackException(String msg){ super(msg); }
}
package TDAPila;

/**
 * Class EmptyStackException.
 * Modela la excepción ante una pila vacía.
 */
public class EmptyStackException extends Exception{
    /**
	 * @param msg Mensaje que describe el evento que disparó la excepción.
	 */
    public EmptyStackException(String msg){ super(msg); }
}
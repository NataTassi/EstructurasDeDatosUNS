package TDACola;

/**
 * Class EmptyQueueException.
 * Modela la excepci�n ante una cola vac�a.
 */
public class EmptyQueueException extends Exception{
    /**
	 * @param msg Mensaje que describe el evento que dispar� la excepci�n.
	 */
    public EmptyQueueException(String msg){ super(msg); }
}
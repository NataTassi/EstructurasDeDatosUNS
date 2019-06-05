package TDACola;

/**
 * Class EmptyQueueException.
 * Modela la excepción ante una cola vacía.
 */
public class EmptyQueueException extends Exception{
    /**
	 * @param msg Mensaje que describe el evento que disparó la excepción.
	 */
    public EmptyQueueException(String msg){ super(msg); }
}
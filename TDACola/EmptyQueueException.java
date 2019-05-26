package TDACola;

/**
 * Class EmptyQueueException.
 * Extiende Exception.
 */
public class EmptyQueueException extends Exception{
    /**
	 * Instancia un objeto de tipo EmptyQueueException.
	 * @param msg Mensaje que describe el evento que dispar� la excepci�n.
	 */
    public EmptyQueueException(String msg){
        super(msg);
    }
}
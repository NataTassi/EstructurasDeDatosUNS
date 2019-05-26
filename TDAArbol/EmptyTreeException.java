package TDAArbol;

/**
 * Class EmptyTreeException.
 * Extiende Exception.
 */
public class EmptyTreeException extends Exception{
    /**
	 * Instancia un objeto de tipo EmptyTreeException.
	 * @param msg Mensaje que describe el evento que disparó la excepción.
	 */
    public EmptyTreeException(String msg){
        super(msg);
    }
}

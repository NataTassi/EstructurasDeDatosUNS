package TDAArbol;

/**
 * Class EmptyTreeException.
 * Extiende Exception.
 */
public class EmptyTreeException extends Exception{
    /**
	 * Instancia un objeto de tipo EmptyTreeException.
	 * @param msg Mensaje que describe el evento que dispar� la excepci�n.
	 */
    public EmptyTreeException(String msg){
        super(msg);
    }
}

package TDAArbol;

/**
 * Class BoundaryViolationException.
 * Extiende Exception.
 */
public class BoundaryViolationException extends Exception{
    /**
	 * Instancia un objeto de tipo BoundaryViolationException.
	 * @param msg Mensaje que describe el evento que dispar� la excepci�n.
	 */
    public BoundaryViolationException(String msg){
        super(msg);
    }
}

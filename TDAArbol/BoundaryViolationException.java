package TDAArbol;

/**
 * Class BoundaryViolationException.
 * Extiende Exception.
 */
public class BoundaryViolationException extends Exception{
    /**
	 * Instancia un objeto de tipo BoundaryViolationException.
	 * @param msg Mensaje que describe el evento que disparó la excepción.
	 */
    public BoundaryViolationException(String msg){
        super(msg);
    }
}

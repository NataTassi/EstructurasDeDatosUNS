package TDALista;

/**
 * Class BoundaryViolationException.
 * Modela la excepción ante solicitud de acceso a una posición inexistente.
 */
public class BoundaryViolationException extends Exception{
    /**
	 * @param msg Mensaje que describe el evento que disparó la excepción.
	 */
    public BoundaryViolationException(String msg){ super(msg); }
}
package TDALista;

/**
 * Class BoundaryViolationException.
 * Modela la excepci�n ante solicitud de acceso a una posici�n inexistente.
 */
public class BoundaryViolationException extends Exception{
    /**
	 * @param msg Mensaje que describe el evento que dispar� la excepci�n.
	 */
    public BoundaryViolationException(String msg){ super(msg); }
}
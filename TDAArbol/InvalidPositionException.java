package TDAArbol;

/**
 * Class InvalidPositionException.
 * Modela la excepción ante una posición pasada inválida.
 */
public class InvalidPositionException extends Exception{
    /**
	 * @param msg Mensaje que describe el evento que disparó la excepción.
	 */
    public InvalidPositionException(String msg){ super(msg); }
}

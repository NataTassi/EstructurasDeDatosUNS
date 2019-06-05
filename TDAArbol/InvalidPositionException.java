package TDAArbol;

/**
 * Class InvalidPositionException.
 * Modela la excepci�n ante una posici�n pasada inv�lida.
 */
public class InvalidPositionException extends Exception{
    /**
	 * @param msg Mensaje que describe el evento que dispar� la excepci�n.
	 */
    public InvalidPositionException(String msg){ super(msg); }
}

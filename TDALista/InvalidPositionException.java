package TDALista;

/**
 * Class InvalidPositionException.
 * Extiende Exception.
 */
public class InvalidPositionException extends Exception{
    /**
	 * Instancia un objeto de tipo InvalidPositionException.
	 * @param msg Mensaje que describe el evento que dispar� la excepci�n.
	 */
    public InvalidPositionException(String msg){
        super(msg);
    }
}
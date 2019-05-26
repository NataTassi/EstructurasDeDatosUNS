package TDALista;

/**
 * Class InvalidPositionException.
 * Extiende Exception.
 */
public class InvalidPositionException extends Exception{
    /**
	 * Instancia un objeto de tipo InvalidPositionException.
	 * @param msg Mensaje que describe el evento que disparó la excepción.
	 */
    public InvalidPositionException(String msg){
        super(msg);
    }
}
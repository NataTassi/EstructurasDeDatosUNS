package TDALista;

/**
 * Class EmptyListException.
 * Extiende Exception.
 */
public class EmptyListException extends Exception{
    /**
	 * Instancia un objeto de tipo EmptyListException.
	 * @param msg Mensaje que describe el evento que dispar� la excepci�n.
	 */
    public EmptyListException(String msg){
        super(msg);
    }
}
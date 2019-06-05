package TDADiccionario;

/**
 * Class InvalidKeyException.
 * Modela la excepci�n ante una clave pasada inv�lida. 
 */
public class InvalidKeyException extends Exception{
    /**
	 * Instancia un objeto de tipo InvalidKeyException.
	 * @param msg Mensaje que describe el evento que dispar� la excepci�n.
	 */
    public InvalidKeyException(String msg){
        super(msg);
    }
}
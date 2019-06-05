package TDADiccionario;

/**
 * Class InvalidKeyException.
 * Modela la excepción ante una clave pasada inválida. 
 */
public class InvalidKeyException extends Exception{
    /**
	 * Instancia un objeto de tipo InvalidKeyException.
	 * @param msg Mensaje que describe el evento que disparó la excepción.
	 */
    public InvalidKeyException(String msg){
        super(msg);
    }
}
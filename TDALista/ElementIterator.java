package TDALista;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ElementIterator.
 * Implementa Iterator.
 * Iterador de DoublyLinkedList.
 *
 * @param <E> Tipo de los elementos de la lista.
 */
public class ElementIterator<E> implements Iterator<E>{
    protected PositionList<E> list;
    protected Position<E> cursor;
    
    /** 
     * Instancia un objeto de tipo ElementIterator. Iterador de la lista.
     * @param l Lista a la que el iterador referencia.
     */
    public ElementIterator(PositionList<E> l){
        list = l;
        try{
            if(l.isEmpty()) cursor = null;
            else cursor = l.first();
        }catch(EmptyListException e){
            System.out.println(e + "\n" + e.getStackTrace());
        }
    }
    
    @Override
    public boolean hasNext(){ return cursor != null; }
    
    @Override
    public E next() throws NoSuchElementException{
        E res = null; 
        try{
            if(cursor == null) throw new NoSuchElementException("It hasn't next");
            res = cursor.element();
            cursor = (cursor == list.last()) ? null : list.next(cursor);
        }catch(InvalidPositionException | EmptyListException | BoundaryViolationException e){
            System.out.println(e + "\n" + e.getStackTrace());
        }
        return res;
    }
}

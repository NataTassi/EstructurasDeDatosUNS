package TDALista;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ElementIterator<E> implements Iterator<E>{
    protected PositionList<E> list;
    protected Position<E> cursor;

    public ElementIterator(PositionList<E> l){
        list = l;
        try{
            if(l.isEmpty()) cursor = null;
            else cursor = l.first();
        }catch(EmptyListException e){
            System.out.println(e + "\n" + e.getStackTrace());
        }
    }

    public boolean hasNext(){
        return cursor != null;
    }

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

package TDALista;
import java.util.*;

public class MyListTester {
	public static <E> PositionList<E> newList(){
		return new DoublyLinkedList<E>();
	}
	
	public static <E> boolean find(PositionList<E> l, E e){
		for(E x : l) if(x.equals(e)) return true;
		return false;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PositionList<String> l = newList();
		int n = in.nextInt();
		for(int i = 0; i < n; i++) l.addLast(in.next());
		
		for(String x : l) System.out.print('[' + x + "] ");
		System.out.println();
		
		Iterator<String> it = l.iterator();
		while(it.hasNext()) System.out.print('(' + it.next() + ") ");
		System.out.println();
		
		for(Position<String> p : l.positions()) System.out.print(p.element() + ' ');
		System.out.println();
		
		System.out.println(l);
		
		String valToFind = in.next();
		System.out.println(valToFind + " was" + (find(l,valToFind) ? "" : " not") + " found in the list"); 
		
		in.close(); 
	}
}

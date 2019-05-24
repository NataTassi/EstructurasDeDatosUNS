package TDAPila;
import java.util.*;

public class MyStackTester {
	public static <E> Stack<E> newStack(){
		return new LinkedStack<E>();
	}
	
	public static <E> void invert(Stack<E> s){
		Stack<E> a = newStack(), b = newStack();
		try {
			while(!s.isEmpty()) a.push(s.pop());
			while(!a.isEmpty()) b.push(a.pop());
			while(!b.isEmpty()) s.push(b.pop());
		} catch(EmptyStackException e){
			System.out.println(e + "\n" + e.getStackTrace());
		}
	}
	
	public static void print(Stack<Integer> s){
		int n = s.size();
		Stack<Integer> a = newStack();
		try {
			for(int i = 0; i < n; i++) {
				int e = s.pop();
				a.push(e);
				System.out.print(e + (i == n-1 ? "\n" : " "));
			}
			while(!a.isEmpty()) s.push(a.pop());
		} catch(EmptyStackException e){
			System.out.println(e + "\n" + e.getStackTrace());
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Stack<Integer> s = new LinkedStack<Integer>();
		for(int i = 0; i < n; i++) s.push(in.nextInt());
		print(s);
		invert(s);
		print(s);
		invert(s);
		print(s);
		in.close();
	}

}

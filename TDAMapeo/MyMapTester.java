
package TDAMapeo;
import java.util.Scanner;

import TDACola.*;

public class MyMapTester {
	public static void characterFrequency(Queue<Character> q){
		int total = q.size();
		Map<Character,Integer> m = new ListMap<Character,Integer>();
		try {
			while(!q.isEmpty()){
				char x = q.dequeue();
				Integer e = m.get(x);
	 			m.put(x, e == null ? 1 : e+1);
			}
		} catch(EmptyQueueException | InvalidKeyException e){
			System.out.println(e + "\n" + e.getStackTrace());
		}
	
		for(Entry<Character,Integer> e : m.entries())
			System.out.println("The frequency of " + e.getKey() + " is " + ((float)e.getValue()/total));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Queue<Character> q = new LinkedQueue<Character>();
		String word = in.next();
 		for(int i = 0; i < word.length(); i++) q.enqueue(word.charAt(i));
 		characterFrequency(q);
		in.close();
	}
}

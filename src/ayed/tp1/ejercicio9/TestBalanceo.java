package tp1.ejercicio9;
import java.util.*;

import tp1.Stack;
public class TestBalanceo {
	
	public static boolean isBalanced(String str) {
		Stack<Character> pila = new Stack<Character>();
		char[] c = str.toCharArray(); 
		for (char i : c) {
			if((i == '(') || (i == '[') || (i == '{')){
				pila.push(i);
			}
			else {
				char temp = pila.pop();
				if ((i == '(') && (temp!= ')')) return false;
				else if ((i == '[') && (temp!= ']')) return false;
				else if ((i == '{') && (temp!= '}')) return false;
			}
		}
		return pila.isEmpty();


	}
	
	public static void main(String[] args) {
		 
		Scanner entrada = new Scanner(System.in);
		String S = entrada.next();
		entrada.close();
		System.out.println(isBalanced(S));
		}

}

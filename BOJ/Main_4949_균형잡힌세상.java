import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		
		L:while(true) {
			
			String str = br.readLine();
			if(str.equals(".")) break;
			stack = new Stack<>();
			
			for(int i=0;i<str.length();i++) {
				char ch = str.charAt(i);
				if(ch=='(') stack.push(ch);
				else if(ch=='[') stack.push(ch);
				else if(ch==')') {
					if(stack.isEmpty()) {
						System.out.println("no");
						continue L;
					}
					char end = stack.peek();
					if(end=='(') stack.pop();
					else {
						System.out.println("no");
						continue L;
					}
				}
				else if(ch==']') {
					if(stack.isEmpty()) {
						System.out.println("no");
						continue L;
					}
					char end = stack.peek();
					if(end=='[') stack.pop();
					else {
						System.out.println("no");
						continue L;
					}
				}
			}
			if(!stack.isEmpty()) System.out.println("no");
			else System.out.println("yes");
		}
	}

}

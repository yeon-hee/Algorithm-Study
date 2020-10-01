import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012_괄호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<N;i++) {
			String answer = "YES";
			String str = br.readLine();
			
			for(int j=0;j<str.length();j++) {
				char ch = str.charAt(j);
				if(ch=='(') stack.add(ch);
				else { // )일때
					if(stack.isEmpty() || stack.peek()!='(') {
						answer = "NO";
						break;
					}
					else stack.pop();
				}
			}
			if(!stack.isEmpty()) answer = "NO";
			System.out.println(answer);
			stack.clear();
		}
	}

}

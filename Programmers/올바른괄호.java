import java.util.Stack;

public class 올바른괄호 {

	boolean solution(String s) {
		boolean answer = true;

		Stack<Character> stack = new Stack<>();
		if(s.length()%2 !=0) return false;

		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='(') stack.push('(');
			else {
				if(stack.isEmpty()) return false;
				else {
					char ch = stack.pop();
					if(ch=='(') continue;
					else return false;
				}
			}
		}

		if(!stack.isEmpty()) return false;
		else return true;
	}

}

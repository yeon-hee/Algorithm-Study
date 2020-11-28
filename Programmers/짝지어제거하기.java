import java.util.*;
public class 짝지어제거하기 {

	public int solution(String s)
	{
		Stack<Character> stack = new Stack<>();

		if(s.length()%2 != 0) return 0;
		for(int i=0;i<s.length();i++){
			if(stack.isEmpty()) stack.push(s.charAt(i));
			else {
				char before = stack.peek();
				if(before == s.charAt(i)){
					stack.pop();
				}
				else stack.push(s.charAt(i));
			}
		}

		if(stack.size()==0) return 1;
		else return 0;
	}

}

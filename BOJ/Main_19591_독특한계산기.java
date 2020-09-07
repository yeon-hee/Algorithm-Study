import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main_19591_독특한계산기 {
	
	static Deque<Long> number;
	static Deque<Character> option;
	static boolean right = false;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		number = new LinkedList<>();
		option = new LinkedList<>();
		String str = br.readLine();
		long answer = 0;
		
		String temp = "";
		String minus = "";
		boolean check = false;
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(!Character.isDigit(ch)) { // 연산자면
				if(i==0) {
					check = true;
					minus += "-";
					continue;
				}
				if(check) {
					minus += temp;
					temp = minus;
					check = false;
				}
				number.add(Long.parseLong(temp));
				option.add(ch);
				temp = "";
			}
			else temp += ch;
			if(i==str.length()-1) number.add(Long.parseLong(temp));
		}
		
		if(number.size()==1) { // 숫자 한개인 경우
			System.out.println(Long.parseLong(str));
			return;
		}
		
		while(number.size()!=1) {
		
			long num1 = number.pollFirst();
			char op1 = option.pollFirst();
			long num2 = number.pollFirst();
			long one = calculation(num1,num2,op1);
			number.addFirst(num2); // 뺀거 다시 넣어주기
			option.addFirst(op1);
			number.addFirst(num1);
			
			long num3 = number.pollLast();
			char op2 = option.pollLast();
			long num4 = number.pollLast();
			long two = calculation(num4,num3,op2);
			number.addLast(num4);
			option.addLast(op2);
			number.addLast(num3);
			
			if(op1!='+' && op1!='-' && op2!='+' && op2!='-') { // 우선순위 같을 경우
				if(one < two) front(two); // 뒤에꺼 빼고 뒤에 결과 넣어주기
				else rear(one);
			}
			else if(op1!='*' && op1!='/' && op2!='*' && op2!='/') {
				if(one < two) front(two);
				else rear(one);
			}
			else { // 우선순위 다를 경우 
				if(op1=='*' || op1=='/') rear(one);
				else front(two);
			}
		}
		
		System.out.println(number.peek());
	}
	
	static void front(long two) { // 뒤에꺼 빼고 뒤에꺼 결과 넣기
		number.pollLast();
		option.pollLast();
		number.pollLast();
		number.addLast(two);
	}
	
	static void rear(long one) { // 앞에꺼 빼고 앞에 결과 넣기
		number.pollFirst();
		option.pollFirst();
		number.pollFirst();
		number.addFirst(one);
	}
	
	static long calculation(long num1, long num2, char ch) {
		if(ch=='+') return num1 + num2;
		else if(ch=='-') return num1 - num2;
		else if(ch=='*') return num1 * num2;
		else return num1 / num2;
	}

}


public class JadenCase문자열만들기 {

	public static void main(String[] args) {

		String s = "3people unFollowed me";
		System.out.println(solution(s));

	}

	static String solution(String s) {
		String answer = "";
		System.out.println(Character.isAlphabetic(' '));
		s = s.toLowerCase();
		boolean isFirst = true;

		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			if(ch == ' ') {
				isFirst = true;
				answer += ch;
			}
			else if(isFirst) {
				answer += Character.toUpperCase(ch);
				isFirst = false;
			}
			else {
				answer += ch;
			}
		}

		return answer;
	}
}

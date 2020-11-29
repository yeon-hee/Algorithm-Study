import java.util.*;

public class 영어끝말잇기 {

	public int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		String before = "";

		Set<String> set = new HashSet<>();
		for(int i=0;i<words.length;i++){
			if(i!=0) {
				before = words[i-1];
				if(words[i].charAt(0) != before.charAt(words[i-1].length()-1)) { // 걸림
					answer[0] = i%n+1;
					answer[1] = i/n+1;
					break;
				}
			}
			if(!set.contains(words[i])) set.add(words[i]);
			else {
				answer[0] = i%n+1;
				answer[1] = i/n+1;
				break;
			}
		}

		return answer;
	}

}

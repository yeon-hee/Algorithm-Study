import java.util.*;

public class 완주하지못한선수 {

	public String solution(String[] participant, String[] completion) {
		String answer = "";

		HashSet<String> set = new HashSet<>();
		for(int i=0;i<participant.length;i++){
			set.add(participant[i]);
		}

		for(int i=0;i<completion.length;i++){
			set.remove(completion[i]);
		}

		for(String person : set) {
			answer = person;
		}

		return answer;
	}

}

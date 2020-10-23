import java.util.*;

public class 최고의집합 {

	public int[] solution(int n, int s) {
		int[] answer = new int[n];

		if(n > s) {
			int result[] = new int[1];
			result[0] = -1;
			return result;
		}

		int num = s / n;
		int sub = s % n;
		Arrays.fill(answer,num);

		for(int i=0;i<sub;i++){
			answer[i]++;
		}

		Arrays.sort(answer);

		return answer;
	}

}

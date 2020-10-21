
public class 카펫 {

	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		int sum = brown + yellow;
		int y = 0;

		for(int i=2;i<=sum/2;i++){
			int x = i; // 세로
			if(sum % i == 0) y = sum/i; // 가로
			if(2*(x+y-2) ==  brown) {
				answer[0] = y;
				answer[1] = x;
				break;
			}
		}
		return answer;
	}

}

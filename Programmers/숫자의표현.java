
public class 숫자의표현 {

	public int solution(int n) {
		int answer = 1;

		for(int i=1;i<=(n+1)/2;i++){
			int sum = i;
			for(int j=i+1;j<n;j++){
				if(sum > n) break;
				else if(sum == n) {
					answer++;
					break;
				}
				else sum += j;
			}
		}

		return answer;
	}

}

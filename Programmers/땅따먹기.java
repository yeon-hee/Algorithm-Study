
public class 땅따먹기 {

	int solution(int[][] land) {

		int answer = 0;
		int len = land.length;

		for(int i=1;i<len;i++){
			land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2],land[i-1][3]));
			land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2],land[i-1][3]));
			land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1],land[i-1][3]));
			land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1],land[i-1][2]));
		}

		for(int i=0;i<4;i++) {
			answer = Math.max(answer,land[len-1][i]);
		}

		return answer;
	}

}

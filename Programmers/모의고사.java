
public class 모의고사 {

	public int[] solution(int[] answers) {

		int[] answer = new int[3];
		int one[] = {1,2,3,4,5};
		int two[] = {2,1,2,3,2,4,2,5};
		int three[] = {3,3,1,1,2,2,4,4,5,5};

		for(int i=0;i<answers.length;i++){
			if(answers[i] == one[i%one.length]) answer[0]++;
			if(answers[i] == two[i%two.length]) answer[1]++;
			if(answers[i] == three[i%three.length]) answer[2]++;
		}

		int max = Math.max(answer[0],Math.max(answer[1],answer[2]));

		int index = 0;
		for(int i=0;i<3;i++){
			if(answer[i]==max) index++;
		}

		int ans[] = new int[index];
		int ind = 0;
		for(int i=0;i<3;i++){
			if(answer[i]==max) ans[ind++] = i+1;
		}

		return ans;
	}

}

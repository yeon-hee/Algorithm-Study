
public class 체육복 {

	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n;

		for(int i=0;i<lost.length;i++){
			for(int j=0;j<reserve.length;j++){
				if(lost[i] == reserve[j]){ // 여벌옷을 도난당함
					lost[i] = -1;
					reserve[j] = -1;
					break;
				}
			}
		}

		for(int i=0;i<reserve.length;i++){
			if(reserve[i]==-1) continue;
			if(reserve[i]==1) {
				for(int j=0;j<lost.length;j++){
					if(lost[j] == 2) lost[j] = -1;
				}
			}
			else {
				int num = reserve[i];
				boolean check = false;
				for(int j=0;j<lost.length;j++){
					if(lost[j] == num-1) {
						check = true;
						lost[j] = -1;
					}
				}
				if(!check){
					for(int j=0;j<lost.length;j++){
						if(lost[j] == num+1) {
							lost[j] = -1;
						}
					}
				}
			}
		}

		for(int j=0;j<lost.length;j++) {
			if(lost[j]!=-1) answer--;
		}
		return answer;
	}

}

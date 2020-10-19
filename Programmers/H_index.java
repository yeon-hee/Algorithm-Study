
public class H_index {

	public int solution(int[] citations) {
		int answer = 0;
		int max = 0;

		for(int i=0;i<citations.length;i++){
			max = Math.max(max, citations[i]);    
		}

		for(int i=0;i<=max;i++){
			boolean check[] = new boolean[citations.length];
			boolean right = true;
			int up = 0;
			for(int j=0;j<citations.length;j++){
				if(i <= citations[j]) {
					check[j] = true;
					up++;
				}
			}
			for(int j=0;j<citations.length;j++){
				if(!check[j]){
					if(citations[j] > i){
						right = false;
						break;
					}
				}
			}
			if(i>=up && right) {
				answer = Math.max(answer, up);
			}
		}
		return answer;
	}
}

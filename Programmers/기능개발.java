
public class 기능개발 {

	public int[] solution(int[] progresses, int[] speeds) {
		
		int len = progresses.length;
		int[] answer = new int[len];
		int count = 0;
		boolean[] isDevelop = new boolean[len];

		for(int i=0;i<len;i++){
			if(isDevelop[i]) continue;
			while(!isDevelop[i]){
				for(int j=0;j<len;j++){
					progresses[j] += speeds[j];
					if(progresses[j]>=100) isDevelop[j] = true;
				}
			}
			if(isDevelop[i]){
				count++;
				for(int j=i;j<len;j++){
					if(isDevelop[j]) answer[i]++;
					else break;
				}
			}
		}

		int result[] = new int[count];
		int index = 0;
		for(int i=0;i<len;i++){
			if(answer[i]!=0) result[index++] = answer[i];
		}

		return result;
	}

}

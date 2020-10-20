
public class 타겟넘버 {

	static int len,num,tar,answer;
	static boolean visited[];
	public int solution(int[] numbers, int target) {
		answer = 0;
		tar = target;

		len = numbers.length;
		visited = new boolean[len];

		for(num=0;num<=len;num++){
			subset(0,0,numbers);
		}


		return answer;
	}

	static void subset(int index, int count, int[] numbers){

		if(index == num){

			int result = 0;
			for(int i=0;i<len;i++){
				if(visited[i]){
					result += (-1)*numbers[i];
				}
				else result += numbers[i];
			}
			if(result == tar) answer++;

			return;
		}

		for(int i=count;i<len;i++){
			visited[i] = true;
			subset(index+1, i+1, numbers);
			visited[i] = false;
		}
	}
}

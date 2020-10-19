
public class 순열검사 {

	public boolean solution(int[] arr) {
		boolean answer = true;
		boolean[] number = new boolean[100001];

		for(int i=0;i<arr.length;i++){
			if(!number[arr[i]]) number[arr[i]] = true;
			else return false;
		}

		for(int i=1;i<=arr.length;i++){
			if(!number[i]) return false;
		}

		return answer;
	}

}

import java.util.*;

public class 줄서는방법 {

	public int[] solution(int n, long k) {
		int answer[] = new int[n];
		long factorial = 1;

		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			list.add(i);
			factorial *= i;
		}

		k--;
		int index = 0;
		while(n>0){
			factorial /= n;
			answer[index++] = list.remove((int)(k/factorial));
			k %= factorial;
			n--;
		}
		return answer;
	}

}

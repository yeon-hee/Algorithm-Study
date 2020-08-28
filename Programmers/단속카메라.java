import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {

	public static void main(String[] args) {

		int array[][] = {{-20,15},{-14,-5},{-18,-13},{-5,-3}};
		System.out.println(solution(array));
	}

	static int solution(int[][] routes) {
		
		int answer = 0;
		Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		int max = Integer.MIN_VALUE;
		for(int[] temp : routes) {
			if(max < temp[0]) {
				max = temp[1];
				answer++;
			}
		}
		return answer;
	}

}

import java.util.HashSet;
import java.util.Set;

public class 순위 {
	public static void main(String[] args) {

		int array[][] = {{4,3},{4,2},{3,2},{1,2},{2,5}};
		int result = solution(5,array);
		System.out.println(result);

	}

	static int solution(int n, int[][] results) {
		int answer = 0;

		Set<Integer> winner[] = new HashSet[n+1];
		Set<Integer> looser[] = new HashSet[n+1];
		for(int i=1;i<=n;i++) winner[i] = new HashSet<>();
		for(int i=1;i<=n;i++) looser[i] = new HashSet<>();

		for(int i=0;i<results.length;i++) {
			int win = results[i][0];
			int lose = results[i][1];
			winner[win].add(lose);
			looser[lose].add(win);
		}
		
		for(int i=1;i<=n;i++) {
			
			for(int j : looser[i]) { 
				for(int k : winner[i]) winner[j].add(k);
			}
			for(int j : winner[i]) {
				for(int k : looser[i]) looser[j].add(k);
			}
		}
		
		for(int i=1;i<=n;i++) {
			if(winner[i].size() + looser[i].size()==n-1) answer++;
		}
		return answer;
	}
}

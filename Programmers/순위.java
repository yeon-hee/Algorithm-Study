import java.util.*;

public class 순위 {

	static int array[];
	public int solution(int n, int[][] results) {
		int answer = 0;
		array = new int[n+1];

		ArrayList<Integer> win[] = new ArrayList[n+1];
		for(int i=1;i<=n;i++) win[i] = new ArrayList<>();
		ArrayList<Integer> lose[] = new ArrayList[n+1];
		for(int i=1;i<=n;i++) lose[i] = new ArrayList<>();

		for(int i=0;i<results.length;i++){
			int first = results[i][0];
			int second = results[i][1];
			win[first].add(second);
			lose[second].add(first);
		}

		competition(win,n);
		competition(lose,n);

		for(int i=1;i<=n;i++) {
			if(array[i] == n-1) answer++;
		}
		return answer;
	}

	static void competition(ArrayList<Integer> list[], int n){

		Queue<Integer> queue = new LinkedList<>();

		for(int i=1;i<=n;i++){
			boolean visited[] = new boolean[n+1];
			queue.offer(i);
			visited[i] = true;
			while(!queue.isEmpty()){
				int current = queue.poll();
				for(int num : list[current]){
					if(!visited[num]){
						visited[num] = true;
						array[num]++;
						queue.offer(num);
					}
				}
			}
		}
	}
}

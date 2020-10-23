import java.util.*;

public class 배달 {

	static class Pair{
		int x; int dist;
		public Pair(int x, int dist){
			this.x = x;
			this.dist = dist;
		}
	}

	static int dist[];
	static ArrayList<Pair> list[];
	public int solution(int N, int[][] road, int K) {
		int answer = 0;

		dist = new int[N+1];
		Arrays.fill(dist,Integer.MAX_VALUE);
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) list[i] = new ArrayList<>();

		for(int i=0;i<road.length;i++){
			int start = road[i][0];
			int end = road[i][1];
			int dist = road[i][2];
			list[start].add(new Pair(end,dist));
			list[end].add(new Pair(start,dist));
		}

		bfs(1);

		for(int i=1;i<=N;i++){
			if(dist[i] <= K) answer++;
		}

		return answer;
	}

	static void bfs(int x){

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(x);
		dist[x] = 0;

		while(!queue.isEmpty()){
			x = queue.poll();
			for(Pair a : list[x]){
				int nx = a.x;
				int time = a.dist;
				if(dist[nx] > dist[x] + time){
					dist[nx] = dist[x] + time;
					queue.offer(nx);
				}
			}
		}
	}

}

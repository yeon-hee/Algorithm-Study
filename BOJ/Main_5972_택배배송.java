import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_5972_택배배송 {
	
	static class Pair implements Comparable<Pair>{
		int x; int cost;
		public Pair(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}
		@Override
		public int compareTo(Pair o) {
			return this.cost - o.cost;
		}
	}
	
	static int N,M,dist[];
	static ArrayList<Pair> list[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new int[N+1];
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) list[i] = new ArrayList<Pair>();
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[start].add(new Pair(end,cost));
			list[end].add(new Pair(start,cost));
		}
		
		int result = bfs(1);
		System.out.println(result);
	}
	
	static int bfs(int start) {
		
		PriorityQueue<Pair> queue = new PriorityQueue<>();
		queue.offer(new Pair(start,0));
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			
			Pair current = queue.poll();
			int x = current.x;
			for(Pair a : list[x]) {
				int nx = a.x;
				if(dist[nx] > dist[x] + a.cost) {
					dist[nx] = dist[x] + a.cost;
					queue.offer(new Pair(nx,dist[nx]));
				}
			}
		}
		
		return dist[N];
	}
}

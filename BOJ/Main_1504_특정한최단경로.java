import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1504_특정한최단경로 {
	
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
	
	static int N,E,dist[];
	static ArrayList<Pair> list[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		dist = new int[N+1];
		
		for(int i=1;i<=N;i++) list[i] = new ArrayList<Pair>();
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[start].add(new Pair(end,cost));
			list[end].add(new Pair(start,cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int ax = Integer.parseInt(st.nextToken());
		int ay = Integer.parseInt(st.nextToken());
		
		int result = 0;
		Arrays.fill(dist, 200000000);
		result += bfs(1,ax);
		Arrays.fill(dist, 200000000);
		result += bfs(ax,ay);
		Arrays.fill(dist, 200000000);
		result += bfs(ay,N);
		
		int sum = 0;
		Arrays.fill(dist, 200000000);
		sum += bfs(1,ay);
		Arrays.fill(dist, 200000000);
		sum += bfs(ay,ax);
		Arrays.fill(dist, 200000000);
		sum += bfs(ax,N);
		
		result = Math.min(result, sum);
		
		if(result>=200000000) System.out.println(-1);
		else System.out.println(result);
				
	}
	
	static int bfs(int start, int end) {
		
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
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
		return dist[end];
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14938_서강그라운드 {
	
	static class Pair implements Comparable<Pair>{
		int x; int cost;
		public Pair(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}
		@Override
		public int compareTo(Pair o) {
			return this.cost-o.cost;
		}
	}
	
	static int N,M,R,array[],dist[];
	static ArrayList<Pair> list[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 수색범위 
		R = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) list[i] = new ArrayList<Pair>();
		
		array = new int[N+1];
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) array[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[start].add(new Pair(end,cost));
			list[end].add(new Pair(start,cost));
		}
		
		int result = Integer.MIN_VALUE;
		
		for(int i=1;i<=N;i++) {
			bfs(i);
			int sum = 0;
			for(int j=1;j<=N;j++) {
				if(dist[j]!=Integer.MAX_VALUE) sum += array[j];
			}
			Arrays.fill(dist, Integer.MAX_VALUE);
			result = Math.max(result, sum);
		}
		
		System.out.println(result);
		
	}
	
	static void bfs(int start) {
		
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.offer(new Pair(start,0));
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			
			Pair current = queue.poll();
			int x = current.x;
			
			for(Pair a : list[x]) {
				int nx = a.x;
				if(dist[nx] > dist[x] + a.cost) {
					if(dist[x] + a.cost <= M) {
						dist[nx] = dist[x] + a.cost;
						queue.offer(new Pair(nx,dist[nx]));
					}
				}
			}
		}
	}
}

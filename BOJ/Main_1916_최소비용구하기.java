import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {
	static class Pair implements Comparable<Pair>{
		int x; int cost;
		public Pair(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
	
	static int N,M,dist[],start,end;
	static ArrayList<Pair> list[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		dist = new int[N+1];
		list = new ArrayList[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=1;i<=N;i++) list[i] = new ArrayList<Pair>();
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[start].add(new Pair(end,cost));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		bfs();
		System.out.println(dist[end]);
	}
	
	static void bfs() {
		
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
		queue.offer(new Pair(start,0));
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			
			Pair current = queue.poll();
			int x = current.x;
			
			for(Pair temp : list[x]) {
				int nx = temp.x;
				if(dist[nx] > dist[x] + temp.cost) {
					dist[nx] = dist[x] + temp.cost;
					queue.offer(new Pair(nx,temp.cost));
				}
			}
		}
	}
}

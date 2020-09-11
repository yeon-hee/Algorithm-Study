import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18223_민준이와마산그리고건우 {
	
	static class Pair implements Comparable<Pair>{
		int x; int dist;
		public Pair(int x, int dist) {
			this.x = x;
			this.dist = dist;
		}
		@Override
		public int compareTo(Pair o) {
			return this.dist - o.dist;
		}
	}
	
	static int V,E,P,dist[];
	static ArrayList<Pair> list[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken()); // 도착지
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken()); // 건우 위치
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		list = new ArrayList[V+1];
		for(int i=1;i<=V;i++) list[i] = new ArrayList<>();
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			list[a].add(new Pair(b,dist));
			list[b].add(new Pair(a,dist));
		}
		
		bfs(1);
		int result = dist[V];
		int friend = dist[P];
		Arrays.fill(dist, Integer.MAX_VALUE);
		bfs(P); // 건우 보고 도착지로 가는 경우
		friend += dist[V];
		if(friend <= result) System.out.println("SAVE HIM");
		else System.out.println("GOOD BYE");
	}
	
	static void bfs(int start) {
		
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
		queue.offer(new Pair(start,0));
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			
			Pair current = queue.poll();
			int x = current.x;
			for(Pair a : list[x]) {
				int nx = a.x;
				if(dist[nx] > dist[x] + a.dist) {
					dist[nx] = dist[x] + a.dist;
					queue.offer(new Pair(nx,dist[nx]));
				}
			}
		}
	}

}

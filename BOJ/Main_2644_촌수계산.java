import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2644_촌수계산 {
	
	static class Pair{
		int x; int dist;
		public Pair(int x, int dist) {
			this.x = x;
			this.dist = dist;
		}
	}
	
	static int N,M,start,end;
	static int answer = -1;
	static boolean visited[],check;
	static ArrayList<Pair> list[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1;i<=N;i++) list[i] = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int par = Integer.parseInt(st.nextToken());
			int son = Integer.parseInt(st.nextToken());
			list[son].add(new Pair(par,0));
			list[par].add(new Pair(son,0));
		}
		
		bfs();
		System.out.println(answer);
	}
	
	static void bfs() {
		
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(start,0));
		
		while(!queue.isEmpty()) {
			
			Pair current = queue.poll();
			int x = current.x;
			int dist = current.dist;
			
			if(x==end) {
				answer = dist;
				return;
			}
			
			for(Pair a : list[x]) {
				int nx = a.x;
				if(!visited[nx]) {
					visited[nx] = true;
					queue.offer(new Pair(nx,dist+1));
				}
			}
		}
	}
}

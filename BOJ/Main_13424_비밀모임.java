import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 비밀모임 {
	static class Pair{
		int x; int cost;
		public Pair(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}
	}
		
	static int N,M,K,dist[][],array[];
	static ArrayList<Pair> list[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1;testcase<=T;testcase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dist = new int[N+1][N+1];
			
			list = new ArrayList[N+1];
			for(int i=1;i<=N;i++) {
				list[i] = new ArrayList<Pair>();
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
		
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				list[start].add(new Pair(end,cost));
				list[end].add(new Pair(start,cost));
			}
			
			K = Integer.parseInt(br.readLine());
			array = new int[K+1];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<K;i++) {
				array[i] = Integer.parseInt(st.nextToken()); // 모임에 있는 친구들
			}
			
			for(int i=1;i<=N;i++) bfs(i); // 시작점
			
			int temp[] = new int[N+1];
			for(int i=0;i<K;i++) {
				for(int j=1;j<=N;j++) {
					temp[j] += dist[array[i]][j];
				}
			}
			
			int min = Integer.MAX_VALUE;
			int answer = 0;
			
			for(int i=1;i<=N;i++) {
				if(min > temp[i]) {
					answer = i;
					min = temp[i];
				}
			}
			
			System.out.println(answer);
		}
	}
	
	static void bfs(int num) {
		
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.offer(new Pair(num,0));
		dist[num][num] = 0;
		
		while(!queue.isEmpty()) {
			
			Pair current = queue.poll();
			int x = current.x;
			for(Pair a : list[x]) {
				int nx = a.x;
				if(dist[num][nx] > dist[num][x] + a.cost) {
					dist[num][nx] = dist[num][x] + a.cost;
					queue.offer(new Pair(nx,dist[num][nx]));
				}
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1766_문제집 {
	
	static class Pair implements Comparable<Pair>{
		int x;
		public Pair(int x) {
			this.x = x;
		}
		@Override
		public int compareTo(Pair o) {
			return this.x - o.x;
		}
	}
	
	static int N,M,degree[];
	static ArrayList<Integer> list[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		degree = new int[N+1];
		for(int i=1;i<=N;i++) list[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			degree[end]++;
		}
		
		bfs();
		
	}
	
	static void bfs() {
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(int i=1;i<=N;i++) {
			if(degree[i]==0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			
			int x = queue.poll();
			System.out.print(x+" ");
			for(int a : list[x]) {
				degree[a]--;
				if(degree[a]==0) queue.offer(a);
			}
		}
	}

}

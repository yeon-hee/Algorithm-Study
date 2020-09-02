import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11657_타임머신 {
	
	static class Pair {
		int start; int end; int cost;
		public Pair(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
	
	static int N,M;
	static long dist[];
	static ArrayList<Pair> list;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new long[N+1];
		list = new ArrayList<Pair>();
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.add(new Pair(start,end,cost));
		}
		
		if(!bfs()) System.out.println(-1);
		else for(int i=2;i<=N;i++) {
			if(dist[i]==Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(dist[i]);
		}
	}
	
	static boolean bfs() {
		
		dist[1] = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				Pair current = list.get(j);
				int start = current.start;
				int end = current.end;
				int cost = current.cost;
				if(dist[start]==Integer.MAX_VALUE) continue;
				if(dist[end] > dist[start] + cost) {
					dist[end] = dist[start] + cost;
				}
			}
		}
		
		for(int i=0;i<M;i++) {
			Pair current = list.get(i);
			int start = current.start;
			int end = current.end;
			int cost = current.cost;
			if(dist[start] != Integer.MAX_VALUE && dist[end] > dist[start] + cost) return false;
		}
		
		return true;
	}
}

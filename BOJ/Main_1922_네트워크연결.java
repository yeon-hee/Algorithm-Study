import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1922_네트워크연결 {
	
	static int N,M;
	static class Pair implements Comparable<Pair>{
		int x; int y; int dist; 
		public Pair(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(Pair o) {
			return this.dist - o.dist;
		}
	}
	
	static int parent[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		Arrays.fill(parent, -1);
		
		ArrayList<Pair> list = new ArrayList<>();
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			list.add(new Pair(start,end,dist));
		}
		
		Collections.sort(list);
		
		int min = 0;
		int cnt = 0;
		int k = 0;
		
		while(k!=list.size() && cnt!=N-1) {
			
			Pair current = list.get(k);
			k++;
			
			int par = current.x;
			int son = current.y;
			if(!union(par,son)) continue;
			
			cnt++;
			min += current.dist;
		}
		
		System.out.println(min);
		
	}
	
	static int find(int x) {
		if(parent[x] < 0) return x;
		return parent[x] = find(parent[x]);
 	}
	
	static boolean union(int x, int y) {
		
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot != yRoot) {
			parent[yRoot] = xRoot;
			return true;
		}
		return false;
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 행성연결 {
	static class Pair implements Comparable<Pair>{
		int x; int y; int cost;
		public Pair(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		@Override
		public int compareTo(Pair o) {
			return this.cost - o.cost;
		}
	}
	
	static int parent[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Pair> list = new ArrayList<Pair>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int cost = Integer.parseInt(st.nextToken());
				list.add(new Pair(i+1,j+1,cost));
			}
		}
		
		Collections.sort(list);
		
		parent = new int[N+1];
		Arrays.fill(parent, -1);
		
		long min = 0;
		int k = 0;
		int cnt = 0;
		
		while(k!=list.size() && cnt!=N-1) {
			
			Pair current = list.get(k);
			k++;
			
			int par = current.x;
			int son = current.y;
			
			if(!union(par,son)) continue;
			
			cnt++;
			min += current.cost;
		}
		
		System.out.println(min);
	}
	
	static int find(int x) {
		if(parent[x]<0) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot!=yRoot) {
			parent[yRoot] = xRoot;
			return true;
		}
		return false;
	}

}

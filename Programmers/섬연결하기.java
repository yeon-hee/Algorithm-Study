import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 섬연결하기 {
	
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
	
	public static void main(String[] args) {
		int array[][] = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		int result = solution(4,array);
		System.out.println(result);
	}
	
	static int parent[];
	static int solution(int n, int[][] costs) {
		int answer = 0;
		ArrayList<Pair> list = new ArrayList<Pair>();
		
		for(int i=0;i<costs.length;i++) {
			int x = costs[i][0];
			int y = costs[i][1];
			int cost = costs[i][2];
			list.add(new Pair(x,y,cost));
		}
		
		Collections.sort(list);
		
		parent = new int[n];
		Arrays.fill(parent, -1);
		
		int min = 0;
		int k = 0;
		int cnt = 0;
		
		while(k!=list.size() && cnt!=n-1) {
			
			Pair current = list.get(k);
			k++;
			
			int par = current.x;
			int son = current.y;
			if(!union(par,son)) continue;
			
			cnt++;
			min += current.cost;
		}
		return min;
	}
	
	static int find(int x) {
		if(parent[x] < 0) return x;
		
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

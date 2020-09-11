import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_14621_나만안되는연애 {
	
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
	
	static int N,M,parents[];
	static char array[];
	static ArrayList<Pair> list;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new char[N+1];
		parents = new int[N+1];
		list = new ArrayList<>();
		Arrays.fill(parents, -1);
		
		String str[] = br.readLine().split(" ");
		for(int i=1;i<=N;i++) array[i] = str[i-1].charAt(0);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			list.add(new Pair(a,b,dist));
		}
		
		Collections.sort(list);
		
		int min = 0;
		int k = 0;
		int cnt = 0;
		
		while(k!=list.size() && cnt!=N-1) {
			
			Pair a = list.get(k);
			k++;
			
			int par = a.x;
			int son = a.y;
			if(array[par] == array[son]) continue; // 같은 성이면 연결하지 않음
			if(!union(par,son)) continue;
			
			min += a.dist;
			cnt++;
		}
		
		int count = 0;
		for(int i=1;i<=N;i++) {
			if(parents[i]==-1) count++;
		}
		
		if(count>1) System.out.println(-1);
		else System.out.println(min);
	}
	
	static int find(int x) {
		
		if(parents[x] < 0) return x;
		return parents[x] = find(parents[x]);
	}
	
	static boolean union(int x, int y) {
		
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot != yRoot) {
			parents[yRoot] = xRoot;
			return true;
		}
		return false;
	}

}

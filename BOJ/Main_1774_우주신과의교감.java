import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1774_우주신과의교감 {
	static class Pair{
		int x; int y; double dist;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Pair(int x, int y, double dist) {
			this(x,y);
			this.dist = dist;
		}

	}
	
	static int N,M,parent[];
	static ArrayList<Pair> list;
	static ArrayList<Pair> array;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		list = new ArrayList<Pair>();
		array = new ArrayList<Pair>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		Arrays.fill(parent, -1);
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Pair(a,b));
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==j) continue;
				Pair a = list.get(i);
				Pair b = list.get(j);
				array.add(new Pair(i+1,j+1,distance(a,b)));
			}
		}
		
		for(int j=0;j<M;j++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		Collections.sort(array, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if(o1.dist - o2.dist < 0) return -1;
				else return 1;
			}
		});
		
		int k = 0;
		double min = 0;
		int cnt = 0;
		
		while(k!=array.size() && cnt!=N-1) {
			
			Pair a = array.get(k);
			int par = a.x;
			int son = a.y;
			k++;
			
			if(!union(par,son)) continue;
			cnt++;
			min += a.dist;
		}
		
		System.out.printf("%.2f",min);
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
	
	static double distance(Pair a, Pair b) {
		
		int ax = a.x;
		int ay = a.y;
		
		int bx = b.x;
		int by = b.y;
		
		return Math.sqrt(Math.pow(ax-bx, 2)+Math.pow(ay-by, 2));
		
	}

}

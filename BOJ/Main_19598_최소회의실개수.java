import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_19598_최소회의실개수 {

	static class Pair implements Comparable<Pair>{
		int x; int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Pair o) {
			if(this.x == o.x) return this.y - o.y;
			else return this.x - o.x;
		}
	}
	
	static int N,array[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N][2];
		ArrayList<Pair> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Pair(start,1));
			list.add(new Pair(end,-1));
		}
		
		Collections.sort(list);
		
		int cnt = 0;
		int answer = 0;
		for(Pair a : list) {
			cnt += a.y;
			answer = Math.max(answer,cnt);
		}
		
		System.out.println(answer);
		
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 최솟값으로이동하기 {
	
	static class Pair{
		int x; int y; 
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int W,H,N,array[][],ans;
	static ArrayList<Pair> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1;testcase<=T;testcase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			list = new ArrayList<Pair>();
			ans = 0;
			
			int dist = 0;
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new Pair(x,y));
			}
			
			for(int i=0;i<N-1;i++) {
				int x = list.get(i).x;
				int y = list.get(i).y;
				
				int nx = list.get(i+1).x;
				int ny = list.get(i+1).y;
				
				if(x <= nx && y <= ny) dist = Math.max(nx-x, ny-y); // 둘 다 큰 경우 - 대각선
				else if(x >= nx && y >= ny) dist = Math.max(x-nx, y-ny);
				else dist = Math.abs(x-nx) + Math.abs(y-ny);
				ans += dist;
			}
			
			System.out.println("#"+testcase+" "+ans);
		}
	}
}

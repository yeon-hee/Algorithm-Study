import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2056_작업 {
	
	static int N,array[],degree[],result[];
	static ArrayList<Integer> list[]; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		array = new int[N+1];
		result = new int[N+1];
		degree = new int[N+1];
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) list[i] = new ArrayList<Integer>();
		
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			array[i] = time;
			for(int j=0;j<num;j++) {
				int work = Integer.parseInt(st.nextToken()); // 먼저 선행되어야 하는 번호
				list[work].add(i);
				degree[i]++;
			}
		}
		
		bfs();
		
		int ans = Integer.MIN_VALUE;
		for(int i=1;i<=N;i++) ans = Math.max(ans, result[i]);
		
		System.out.println(ans);
		
	}
	
	static void bfs() {
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			result[i] = array[i];
			if(degree[i]==0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			
			int x = queue.poll();
			for(int a : list[x]) {
				result[a] = Math.max(result[a], result[x] + array[a]);
				degree[a]--;
				
				if(degree[a]==0) queue.offer(a);
			}
		}
	}
}

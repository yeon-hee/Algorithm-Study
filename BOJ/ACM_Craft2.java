import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACM_Craft2 {
	static int N,K,W,time[],degree[],result[];
	static ArrayList<Integer> array[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1;testcase<=T;testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			array = new ArrayList[N+1];
			degree = new int[N+1];
			time = new int[N+1];
			result = new int[N+1];
			
			for(int i=1;i<=N;i++) array[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1;i<=K;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				array[start].add(end);
				degree[end]++;
			}
			
			W = Integer.parseInt(br.readLine());
			bfs();
			
		}
	}
	
	static void bfs() {
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			result[i] = time[i];
			if(degree[i]==0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			
			int current = queue.poll();
			for(int a : array[current]) {
				result[a] = Math.max(result[a], result[current]+time[a]);
				degree[a]--;
				
				if(degree[a]==0) queue.offer(a);
			}
		}
		
		System.out.println(result[W]);
	}
}

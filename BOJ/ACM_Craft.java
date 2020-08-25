import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACM_Craft {
	
	static int N,K,W,list[],indegree[],result[];
	static ArrayList<Integer> array[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=0;testcase<T;testcase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			list = new int[N+1];
			indegree = new int[N+1];
			result = new int[N+1];
			array = new ArrayList[N+1];
			for(int i=1;i<=N;i++) array[i] = new ArrayList<Integer>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				array[start].add(end);
				indegree[end]++;
			}
			
			W = Integer.parseInt(br.readLine()); // 지어야 하는 건물
			bfs();
		}
		
	}
	
	static void bfs() {
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			result[i] = list[i];
			if(indegree[i]==0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			
			int current = queue.poll();
			for(int a : array[current]) {
				result[a] = Math.max(result[a], result[current]+list[a]);
				indegree[a]--;
				if(indegree[a]==0) queue.offer(a);
			}
		}
		System.out.println(result[W]);
	}
}

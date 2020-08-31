import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14567_선수과목 {
	static int N,M,array[],degree[],result[];
	static ArrayList<Integer> list[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N+1];
		degree = new int[N+1];
		result = new int[N+1];
		
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();	
			array[i] = 1;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			degree[end]++;
		}
		
		bfs();
		
		for(int i=1;i<=N;i++) {
			System.out.print(result[i]+" ");
		}
		
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

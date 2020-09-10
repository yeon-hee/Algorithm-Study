import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11725_트리의부모찾기 {
	
	static int N,parent[];
	static ArrayList<Integer> list[]; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		parent = new int[N+1];
		for(int i=1;i<=N;i++) list[i] = new ArrayList<>();
		
		for(int i=0;i<N-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			list[end].add(start);
		}
		
		parent[1] = 1;
		bfs(1);
		
		for(int i=2;i<=N;i++) System.out.println(parent[i]);
		
	}
	
	static void bfs(int start) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			
			int x = queue.poll();
			for(int a : list[x]) {
				if(parent[a]==0) {
					parent[a] = x;
					queue.offer(a);
				}
			}
		}
	}
}

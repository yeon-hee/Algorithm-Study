import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1516_게임개발 {
	
	static int N,degree[],time[],result[];
	static ArrayList<Integer> list[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		degree = new int[N+1];
		time = new int[N+1];
		result = new int[N+1];
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) list[i] = new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = 0;
			while(true) {
				int num = Integer.parseInt(st.nextToken()); // 먼저 지어져야 하는 건물
				if(num==-1) break;
				if(index==0) time[i] = num;
				else {
					list[num].add(i);
					degree[i]++;
				}
				index++;
			}
		}
		
		bfs();
		for(int i=1;i<=N;i++) System.out.println(result[i]);
		
	}
	
	static void bfs() {
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			result[i] = time[i];
			if(degree[i]==0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			
			int x = queue.poll(); // 먼저
			for(int a : list[x]) { // 뒤에
				result[a] = Math.max(result[a], result[x]+time[a]);
				degree[a]--;
				if(degree[a]==0) queue.offer(a);
			}
		}
	}

}

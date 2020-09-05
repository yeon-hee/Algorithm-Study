import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2637_장난감조립 {

	static class Pair{
		int x; int cnt;
		public Pair(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}

	static int N,M,degree[],result[][];
	static ArrayList<Pair> list[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		degree = new int[N+1];
		result = new int[N+1][N+1];
		for(int i=1;i<=N;i++) list[i] = new ArrayList<>();

		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int end = Integer.parseInt(st.nextToken()); // 중간부품
			int start = Integer.parseInt(st.nextToken()); // 기본부품
			int cnt = Integer.parseInt(st.nextToken()); // 갯수
			list[start].add(new Pair(end,cnt));
			degree[end]++;
		}

		bfs();

	}

	static void bfs() {

		Queue<Integer> queue = new LinkedList<>();

		for(int i=1;i<=N;i++) {
			if(degree[i]==0) {
				result[i][i] = 1; // 기본부품이 어떤건지 알 수 없음
				queue.offer(i);
			}
		}

		while(!queue.isEmpty()) {

			int x = queue.poll();
			for(Pair a : list[x]) {
				int nx = a.x;
				int cnt = a.cnt;
				for(int i=1;i<=N;i++) {
					result[nx][i] +=  result[x][i] * cnt;
				}
				degree[nx]--;
				if(degree[nx]==0) queue.offer(nx);
			}
		}

		for(int i=1;i<=N;i++) {
			if(result[N][i]!=0) System.out.println(i+" "+result[N][i]);
		}
	}
}

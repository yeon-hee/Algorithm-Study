import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {
	static class Pair{
		int x; int dist;
		public Pair(int x, int dist) {
			this.x = x;
			this.dist = dist;
		}
	}
	static boolean visited[];
	static int temp[],max;
	static ArrayList<Integer> list[];
	public static void main(String[] args) {

		int array[][] = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		int result = solution(6, array);
		System.out.println(result);
	}
	
	static int solution(int n, int[][] edge) {
		int answer = 0;
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		temp = new int[n+1];
		
		for(int i=1;i<=n;i++) list[i] = new ArrayList<Integer>();
		
		for(int i=0;i<edge.length;i++) {
			int start = edge[i][0];
			int end = edge[i][1];
			list[start].add(end);
			list[end].add(start);
		}
		
		bfs();
		
		for(int i=2;i<=n;i++) {
			if(temp[i]==max) answer++;
		}
		
		return answer;
	}
	
	static void bfs() {
		
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(1,1));
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			
			Pair current = queue.poll();
			int x = current.x;
			int dist = current.dist;
			
			for(int a : list[x]) {
				if(!visited[a]) {
					temp[a] = dist;
					max = Math.max(max, dist);
					visited[a] = true;
					queue.offer(new Pair(a,dist+1));
				}
			}
		}
	}
}

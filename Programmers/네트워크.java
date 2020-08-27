import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {
	
	public static void main(String[] args) {
		
		int array[][] = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int result = solution(3,array);
		
		System.out.println(result);
	}

	static ArrayList<Integer> array[];
	static boolean visited[];
	static int temp[],ans;
	static int solution(int n, int[][] computers) {
        int answer = 0;
        array = new ArrayList[n+1];
        visited = new boolean[n+1];
        temp = new int[n+1];
        for(int i=1;i<=n;i++) array[i] = new ArrayList<Integer>();
        
        for(int i=0;i<computers.length;i++) {
        	for(int j=0;j<computers[i].length;j++) {
        		if(i!=j && computers[i][j]==1) { // 자기 자신이 아닐 때
        			array[i+1].add(j+1);
        		}
        	}
        }
        
        for(int i=1;i<=n;i++) bfs(i);
        return ans;
    }
	
	static void bfs(int num) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(num);
		visited[num] = true;
		if(temp[num]==0) {
			temp[num] = num;
			ans++;
		}
		
		while(!queue.isEmpty()) {
			
			int x = queue.poll();
			
			for(int a : array[x]) {
				if(!visited[a]) {
					visited[a] = true;
					temp[a] = num;
					queue.offer(a);
				}
			}
		}
	}
}

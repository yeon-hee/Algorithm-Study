import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
	
	static class Pair{
		String str; int dist;
		public Pair(String str, int dist) {
			this.str = str;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) {
		
		String words[] = {"hot", "dot", "dog", "lot", "log", "cog"};
		int result = solution("hit","cog",words);
		System.out.println(result);
	}
	
	static String words[];
    static int solution(String begin, String target, String[] words) {
        int answer = bfs(begin, target, words);
        
        return answer;
    }
    
    
    static boolean visited[];
    static int bfs(String begin, String target, String[] words) {
    	
    	int num = words.length;
    	visited = new boolean[num];
    	Queue<Pair> queue = new LinkedList<Pair>();
    	queue.offer(new Pair(begin,0));
    	
    	while(!queue.isEmpty()) {
    		
    		Pair current = queue.poll();
    		begin = current.str;
    		int dist = current.dist;
    		if(begin.equals(target)) return dist;
    		
    		L:for(int i=0;i<num;i++) {
    			String nx = words[i];
    			int count = 0;
    			for(int j=0;j<nx.length();j++) {
    				if(nx.charAt(j)!=begin.charAt(j)) count++;
    				if(count>1) continue L;
    			}
    			if(!visited[i]) {
    				visited[i] = true;
    				queue.offer(new Pair(nx,dist+1));
    			}
    		}
    	}
    	
    	return 0;
    }

}

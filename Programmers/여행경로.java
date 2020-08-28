import java.util.Arrays;
import java.util.Comparator;

public class 여행경로 {

	public static void main(String[] args) {

		String[][] array = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[] result = solution(array);
		for(int i=0;i<result.length;i++) System.out.print(result[i]+" ");
	}
	
	static int len,index;
	static boolean visited[],check;
	static String array[][],answer[],result[];
	static String[] solution(String[][] tickets) {
		
		len = tickets.length;
		answer = new String[len+1];
		result = new String[len+1];
		visited = new boolean[len];
		array = tickets;
		Arrays.sort(tickets, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[0].equals(o2[0])) return o1[1].compareTo(o2[1]);
				else return o1[0].compareTo(o2[0]);
			}
		});
		
		for(int i=0;i<len;i++) {
			visited[i] = true;
			answer[0] = tickets[i][0];
			dfs(tickets[i][0],tickets[i][1],1,answer);
			visited[i] = false;
			if(check) break;
		}
		
		return result;
	}
	
	static void dfs(String start, String end, int index, String[] ans) {
		
		if(check) return;
		
		if(index==len) {
			if(!ans[0].equals("ICN")) return;
			check = true;
			result = ans;
			return;
		}
		
		for(int i=0;i<len;i++) {
			String nx = array[i][0];
			String ny = array[i][1];
			if(end.equals(nx) && !visited[i]) {
				visited[i] = true;
				String[] temp = ans.clone();
				temp[index] = nx;
				if(index==len-1) temp[index+1] = ny;
				dfs(nx,ny,index+1,temp);
				visited[i] = false;
			}
		}
	}
}

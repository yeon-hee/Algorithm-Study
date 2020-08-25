import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 규영이와인영이의카드게임 {
	
	static int gue[],iny[],win,lose;
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1;testcase<=T;testcase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			gue = new int[9]; // 규영
			iny = new int[9]; // 인영
			visited = new boolean[19];
			win = 0;
			lose = 0;
			
			for(int i=0;i<9;i++) {
				gue[i] = Integer.parseInt(st.nextToken());
				visited[gue[i]] = true;
			}
			
			permutation(0);
			
			System.out.println("#"+testcase+" "+win+" "+lose);
		}
		
	}
	
	static void permutation(int index) {
		
		if(index==9) {
			
			game();
			return;
		}
		
		for(int i=1;i<=18;i++) {
			if(!visited[i]) {
				visited[i] = true;
				iny[index] = i;
				permutation(index+1);
				visited[i] = false;
			}
		}
	}
	
	static void game() {
		
		// 규영이가 이기는 경우 & 지는 경우 
		int one = 0;
		int two = 0;
		
		for(int i=0;i<9;i++) {
			if(gue[i] < iny[i]) two += (gue[i] + iny[i]);
			else if(gue[i] > iny[i]) one += (gue[i] + iny[i]);
		}
		
		if(one > two) win++;
		else if(one < two) lose++;
	}
}

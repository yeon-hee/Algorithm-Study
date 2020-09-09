import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12790_MiniFantasyWar {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1;testcase<=T;testcase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int hp = Integer.parseInt(st.nextToken());
			int mp = Integer.parseInt(st.nextToken());
			int push = Integer.parseInt(st.nextToken());
			int pull = Integer.parseInt(st.nextToken());

			hp += Integer.parseInt(st.nextToken());
			mp += Integer.parseInt(st.nextToken());
			push += Integer.parseInt(st.nextToken());
			pull += Integer.parseInt(st.nextToken());
			
			if(hp<1) hp = 1;
			if(mp<1) mp = 1;
			if(push<0) push = 0;
			
			int result = hp + 5*mp + 2*push + 2*pull;
			System.out.println(result);
		}
	}

}

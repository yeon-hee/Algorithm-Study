import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 암기왕 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int testcase=0;testcase<T;testcase++) {
			
			int N = Integer.parseInt(br.readLine());
			HashMap<Integer,Integer> map = new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				map.put(Integer.parseInt(st.nextToken()), 1);
			}
			
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				int num = Integer.parseInt(st.nextToken());
				if(map.get(num)==null) bw.write(0+"\n");
				else bw.write(1+"\n");
			}
		}
		bw.flush();
		bw.close();
	}

}

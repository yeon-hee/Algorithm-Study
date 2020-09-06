import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_10159_저울 {
	
	static int N,M,array[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N+1];
		
		M = Integer.parseInt(br.readLine());
		Set<Integer> heavy[] = new HashSet[N+1];
		Set<Integer> light[] = new HashSet[N+1];
		
		for(int i=1;i<=N;i++) heavy[i] = new HashSet<>();
		for(int i=1;i<=N;i++) light[i] = new HashSet<>();
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			heavy[first].add(second);
			light[second].add(first);
		}
		
		for(int i=1;i<=N;i++) {
			
			for(int j : heavy[i]) { // j는 가벼움
				for(int k : light[i]) { // k는 무거움
					heavy[k].add(j);
				}
			}
			
			for(int j : light[i]) { // j는 무거웁
				for(int k : heavy[i]) { // k는 가벼움
					light[k].add(j);
				}
			}
		}
		
		int result[] = new int[N+1];
		for(int i=1;i<=N;i++) {
			System.out.println(N-(heavy[i].size() + light[i].size())-1);
		}
		
	}

}

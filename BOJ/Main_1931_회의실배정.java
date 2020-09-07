import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1931_회의실배정 {

	static int N,array[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			array[i][0] =  Integer.parseInt(st.nextToken());
			array[i][1] =  Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) return o1[0] - o2[0];
				else return o1[1] - o2[1];
			}
		});
		
		int max = Integer.MIN_VALUE;
		int answer = 0;
		for(int i=0;i<N;i++) {
			if(max <= array[i][0]) {
				max = array[i][1];
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}

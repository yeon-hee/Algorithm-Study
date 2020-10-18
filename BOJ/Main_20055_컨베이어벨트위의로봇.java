import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20055_컨베이어벨트위의로봇 {

	static int N,K,array[],robot[],answer;
	static int count = 1;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		array = new int[N*2];
		robot = new int[N*2];
		int result = 0;

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N*2;i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		while(true) {
			result++;
			move(); // 한칸 회전
			robotMove(); // 로봇 이동
			if(robot[0]==0 && array[0] > 0) {
				robot[0] = count++;
				array[0]--;
			}
			for(int i=0;i<N*2;i++) {
				if(array[i]<=0) answer++;
			}
			if(answer>=K) break;
			else answer = 0;
		}

		System.out.println(result);
	}

	static void robotMove() {

		for(int j=N*2-1;j>=0;j--) {
			if(j>=N-1) robot[j] = 0;
			else {
				if(robot[j]!=0 && robot[j+1]==0 && array[j+1]>0) {
					robot[j+1] = robot[j];
					robot[j] = 0;
					array[j+1]--;
				}
			}
		}
	}

	static void move() { // 내구도도 같이 회전 

		int last = array[N*2-1];
		for(int i=N*2-1;i>0;i--) {
			array[i] = array[i-1];
			robot[i] = robot[i-1];
		}
		robot[0] = 0;
		array[0] = last;

		for(int i=N;i<N*2;i++) robot[i] = 0;
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {

	static int array[][],blueCnt,whiteCnt;
	static boolean check,visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		visited = new boolean[N][N];

		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0,0,N);
		System.out.println(whiteCnt);
		System.out.println(blueCnt);

	}

	static int dx[] = {0,0,1,1};
	static int dy[] = {0,1,0,1};
	static void divide(int x, int y, int number) {

		int color = array[x][y];
		
		for(int i=x;i<x+number;i++) {
			for(int j=y;j<y+number;j++) {
				if(array[i][j]!=color) {
					int size = number/2;
					divide(x,y,size);
					divide(x+size,y,size);
					divide(x,y+size,size);
					divide(x+size,y+size,size);
					return;
				}
			}
		}

		if(color == 0) whiteCnt++;
		else blueCnt++;
	}
}

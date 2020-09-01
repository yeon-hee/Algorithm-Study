import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2239_스도쿠 {

	static class Pair{
		int x; int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int array[][];
	static boolean check;
	static ArrayList<Pair> list = new ArrayList<Pair>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		array = new int[9][9];

		for(int i=0;i<9;i++) {
			String str = br.readLine();
			for(int j=0;j<9;j++) {
				array[i][j] = str.charAt(j) - '0';
				if(array[i][j]==0) list.add(new Pair(i,j));
			}
		}

		dfs(0);

	}

	static void dfs(int index) {

		if(check) return;

		if(index==list.size()) {

			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					if(array[i][j]==0) return;
				}
			}
			check = true;
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(array[i][j]);
				}
				System.out.println();
			}
			return;
		}

		int x = list.get(index).x;
		int y = list.get(index).y;

		for(int k=1;k<=9;k++) {
			if(check(x,y,k)) {
				array[x][y] = k;
				dfs(index+1);
				array[x][y] = 0;
			}
		}

	}

	static boolean check(int x, int y, int num) {

		for(int i=0;i<9;i++) {
			if(array[x][i]==num) return false;
			if(array[i][y]==num) return false;
		}

		for(int i=x/3*3;i<x/3*3+3;i++) {
			for(int j=y/3*3;j<y/3*3+3;j++) {
				if(array[i][j]==num) return false;
			}
		}

		return true;
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16985_Maaaaaaaaaze {

	static class Pair{
		int x; int y; int cnt;
		public Pair(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static int array[][],temp[][],map[];
	static boolean selected[];
	static ArrayList<int[][]> list;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		array = new int[5][5];
		temp = new int[5][5];
		map = new int[25];
		selected = new boolean[20];
		list = new ArrayList<>();

		for(int i=0;i<25;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				array[i%5][j] = Integer.parseInt(st.nextToken());
			}
			if(i%5==4) {
				int map1[][] = new int[5][5];
				for(int k=0;k<5;k++) map1[k] = array[k].clone();
				list.add(map1);
				for(int j=0;j<3;j++) {
					for(int x=0;x<5;x++) {
						for(int y=0;y<5;y++) {
							temp[y][4-x] = array[x][y];
						}
					}

					map1 = new int[5][5];
					for(int k=0;k<5;k++) map1[k] = temp[k].clone();
					list.add(map1);

					for(int k=0;k<5;k++) {
						array[k] = temp[k].clone();
						Arrays.fill(temp[k], 0);
					}
				}
			}
		}

		permutation(0);
		if(answer==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);

	}

	static void permutation(int index) {

		if(index==5) {

			int cnt1 = 0;
			int cnt2 = 0;
			int cnt3 = 0;
			int cnt4 =0;
			int cnt5 = 0;
			for(int i=0;i<5;i++) {
				if(0<=map[i] && map[i]<4) cnt1++;
				else if(4<=map[i] && map[i]<8) cnt2++;
				else if(8<=map[i] && map[i]<12) cnt3++;
				else if(12<=map[i] && map[i]<16) cnt4++;
				else if(16<=map[i] && map[i]<20) cnt5++;
			}
			
			if(1<cnt1 || 1<cnt2 || 1<cnt3 || 1<cnt4 || 1<cnt5) return;
			move();
			return;
		}

		for(int i=0;i<20;i++) {
			if(!selected[i]) {
				selected[i] = true;
				map[index] = i;
				permutation(index+1);
				selected[i] = false;
			}
		}
	}

	static int dx[] = {0,0,1,-1,5,-5}; // 양옆, 위 아래 
	static int dy[] = {1,-1,0,0,0,0};
	static void move() {

		int array[][] = new int[25][5];

		for(int i=0;i<5;i++) {
			int temp[][] = new int[5][5];
			temp = list.get(map[i]);
			for(int x=0;x<5;x++) {
				for(int y=0;y<5;y++) {
					array[x+5*i][y] = temp[x][y];
				}
			}
		}

		Queue<Pair> queue = new LinkedList<Pair>();
		boolean visited[][] = new boolean[25][5];
		if(array[0][0]==1) queue.offer(new Pair(0,0,0));
		else return;

		while(!queue.isEmpty()) {

			Pair current = queue.poll();
			int x = current.x;
			int y = current.y;
			int cnt = current.cnt;

			if(x==24 && y==4) {
				answer = Math.min(answer, cnt);
				return;
			}

			for(int i=0;i<6;i++) {
				if(x%5==4 && i==2) continue; 
				if(x%5==0 && i==3) continue; 
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0<=nx && nx<25 && 0<=ny && ny<5 && array[nx][ny]==1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.offer(new Pair(nx,ny,cnt+1));
				}

			}

		}

	}

}

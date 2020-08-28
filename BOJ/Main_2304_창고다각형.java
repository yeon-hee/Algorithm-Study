import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 창고다각형 {

	static class Pair implements Comparable<Pair>{
		int x; int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Pair o) {
			return this.x - o.x;
		}
	}

	static int N;
	static ArrayList<Pair> list;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<Pair>();

		int max = Integer.MIN_VALUE;
		int temp = 0;

		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Pair(x,y));
			if(max < y) {
				temp = x;
				max = y;
			}
		}

		Collections.sort(list);

		int tmp[] = new int[list.get(list.size()-1).x+1];

		max = list.get(0).y;
		int index = list.get(0).x;

		for(int i=0;i<list.size();i++){
			int x = list.get(i).x;
			int y = list.get(i).y;
			if(max < y) {
				tmp[x] = y;
				max = y;
			}
			else tmp[x] = max;
			if(index==temp) {
				tmp[x] = y;
				break;
			}
			
			if(index<temp) {
				for(int j=index;j<list.get(i+1).x;j++) {
					tmp[j] = max;
					index++;
				}
			}
		}
		tmp[temp] = max;
		
		max = list.get(list.size()-1).y;
		index = list.get(list.size()-1).x;
		for(int i=list.size()-1;i>=0;i--){
			int x = list.get(i).x;
			int y = list.get(i).y;
			if(max < y) {
				tmp[x] = y;
				max = y;
			}
			else tmp[x] = max;
			if(x==temp) break;
			
			if(x>temp) {
				for(int j=index;j>list.get(i-1).x;j--) {
					tmp[j] = max;
					index--;
				}
			}
		}
		
		int result = 0;
		for(int i=0;i<tmp.length;i++) {
			result += tmp[i];
		}

		System.out.println(result);
	}

}

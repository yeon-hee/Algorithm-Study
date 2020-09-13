import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2383_점심식사시간 {

	static class Pair implements Comparable<Pair>{
		int x; int y; 

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			return this.y - o.y; // 거리 오름차순
		}

	}

	static int N,array[][],people[],ans;
	static boolean check = false;
	static ArrayList<Pair> stair;
	static ArrayList<Pair> list;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int testcase=1;testcase<=T;testcase++) {

			N = Integer.parseInt(br.readLine());
			array = new int[N][N];
			stair = new ArrayList<Pair>();
			list = new ArrayList<Pair>();
			ans = Integer.MAX_VALUE;

			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
					if(array[i][j]>1) stair.add(new Pair(i,j)); // 계단
					else if(array[i][j]==1) list.add(new Pair(i,j)); // 사람
				}
			}

			people = new int[list.size()];
			permutation(0);
			System.out.println("#"+testcase+" "+ans);
		}
	}

	static void permutation(int index) {

		if(index==list.size()) {
			move();
			return;
		}

		for(int i=0;i<2;i++) { // 1계단 선택하거나, 2계단 선택함 - 순열(모든 경우)
			people[index] = i;
			permutation(index+1);
		}
	}

	static void move() {

		PriorityQueue<Pair> one = new PriorityQueue<>();
		PriorityQueue<Pair> temp = new PriorityQueue<>();
		Pair stair1 = stair.get(0);
		Pair stair2 = stair.get(1);

		for(int i=0;i<list.size();i++) {
			Pair a = list.get(i);
			if(people[i]==0) one.offer(new Pair(1,Math.abs(a.x-stair1.x)+Math.abs(a.y-stair1.y))); // 첫번째 계단
			else one.offer(new Pair(2,Math.abs(a.x-stair2.x)+Math.abs(a.y-stair2.y))); // 두번째 계단
		}

		PriorityQueue<Integer> queue1 = new PriorityQueue<>();
		PriorityQueue<Integer> queue2 = new PriorityQueue<>();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int cnt = 0;

		while(true) {

			if(queue1.isEmpty() && queue2.isEmpty() && one.isEmpty()) break;
			while(!queue1.isEmpty()) {
				int a = queue1.poll();
				if(a-1!=0) queue.offer(a-1); // 1칸 내려감
			}
			if(!queue.isEmpty()) {
				for(int a : queue) queue1.offer(a);
				queue.clear();
			}
			
			while(!queue2.isEmpty()) {
				int a = queue2.poll();
				if(a-1!=0) queue.offer(a-1); // 1칸 내려감
			}
			if(!queue.isEmpty()) {
				for(int a : queue) queue2.offer(a);
				queue.clear();
			}
			
			
			while(!one.isEmpty()) {
				Pair current = one.poll();
				int x = current.x;
				int time = current.y;
				if(time==0) {
					if(x==1) { // 계단1에 3명 이하로 있으면 
						if(queue1.size()<3) queue1.offer(array[stair1.x][stair1.y]);
						else temp.offer(new Pair(x,time)); // 계단 꽉차있으면 대기
					}
					else if(x==2) { // 계단2에 3명 이하로 있으면 
						if(queue2.size()<3) queue2.offer(array[stair2.x][stair2.y]);
						else temp.offer(new Pair(x,time));
					}
				}
				else temp.offer(new Pair(x,time-1));
			}
			
			for(Pair a : temp) one.offer(a);
			temp.clear();
			cnt++;
		}
		
		ans = Math.min(ans, cnt);
	}

}

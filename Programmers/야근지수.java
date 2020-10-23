import java.util.*;

public class 야근지수 {

	public long solution(int n, int[] works) {
		long answer = 0;

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<works.length;i++){
			queue.offer(works[i]);
		}

		while(true){

			if(queue.isEmpty() || n==0) break;
			int num = queue.poll();
			n--;
			if(num>0) queue.offer(num-1);
		}

		for(int a : queue){
			answer += Math.pow(a,2);
		}
		return answer;
	}

}

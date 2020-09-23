import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
	
	static class Pair{
		int x; int time;
		public Pair(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		
		int array[] = {10,10,10,10,10,10,10,10,10,10};
		int result = solution(100,100,array);
		System.out.println(result);
	}
	
	static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0; // weight 이하여야 한다
        Queue<Integer> queue = new LinkedList<>();
        Queue<Pair> temp = new LinkedList<>();
        for(int i=0;i<truck_weights.length;i++) queue.offer(truck_weights[i]);
        ArrayList<Pair> list = new ArrayList<>();
        while(true) {
        	
        	sum = 0;
        	answer++;
        	int time = 0;
        	if(answer==100) {
        		System.out.println("여기");
        	}
        	
        	int size = temp.size();
        	for(int i=0;i<size;i++) {
        		Pair a = temp.poll();
        		temp.offer(new Pair(a.x,a.time+1)); // 1초 지남
        	}
        	
        	for(Pair a : temp) {
        		time = a.time;
        		if(time==bridge_length) list.add(a);
        	}
        	for(Pair a : list) temp.remove(a);
        	list.clear();
        	for(Pair a : temp) sum += a.x;
        	
        	if(!queue.isEmpty()) {
        		if(sum + queue.peek() <= weight) {
            		int num = queue.poll();
            		temp.offer(new Pair(num,0));
            	}
        	}
        	if(temp.isEmpty()) break;
        }
        
        return answer;
    }

}

import java.util.PriorityQueue;

public class 더맵게 {
	
	public static void main(String[] args) {
		
		int array[] = {1,2,3,9,10,12};
		
		int result = solution(array,7);
		System.out.println(result);
	}
	static int solution(int[] scoville, int K) {
        int answer = 0;
        int status = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++) queue.offer(scoville[i]);
        
        while(true) {
        	
        	if(queue.peek() >= K) break;
        	if(queue.size()<2) { // 만들 수 없는 경우
        		answer = -1;
        		break;
        	}
        	int first = queue.poll();
        	int second = queue.poll();
        	queue.offer(first + second*2);
        	answer++;
        }
        return answer;
    }

}

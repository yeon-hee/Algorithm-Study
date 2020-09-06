import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
	
	static class Pair implements Comparable<Pair>{
		int x; int time;
		public Pair(int x, int time) {
			this.x = x;
			this.time = time;
		}
		@Override
		public int compareTo(Pair o) {
			return this.time - o.time; // 요청시간 오름차순
		}
	}
	
	public static void main(String[] args) {
		
		int array[][] = {{0,3},{1,9},{2,6}};
		int result = solution(array);
		System.out.println(result);
		
	}
	
    static int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
              if (o1[0] == o2[0])  // 만약 요청시간이 같다면
                return o1[1] - o2[1]; // 작업 처리 시간이 짧은 애를 앞으로 정렬한다.
              return o1[0] - o2[0]; // 그 외는 요청 시간이 빠른 순서대로 정렬한다.
            }
        });
        
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        
        int cnt = jobs[0][0] + jobs[0][1];
        int s = 1; // 다음 작업부터 
        int complete = 1; // 모든 작업이 완료되면 종료
        answer = cnt - jobs[0][0]; // 대기하는 시간
        
        while(complete != jobs.length) {
        	
        	for(int i=s;i<jobs.length;i++) {
        		if(cnt >= jobs[i][0]) { // 작업의 요청시간이 현재시간보다 크거나 같다면
        			queue.offer(new Pair(jobs[i][0], jobs[i][1]));
        			if(i==jobs.length-1) s = jobs.length;
        		}
        		else { // 요청시간이 현재시간보다 작으면
        			s = i;
        			break;
        		}
        	}
        	
        	// 실행할 수 있는 작업 목록이 있다면
        	if(!queue.isEmpty()) {
        		Pair a  = queue.poll();
        		cnt += a.time;
        		answer += cnt - a.x;
        		complete++;
        	} 
        	else cnt = jobs[s][0]; // 바로 실행할 수 있는 작업 목록이 없다면
        }
        
        return answer/jobs.length;
    }

}

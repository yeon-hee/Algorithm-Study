import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
	public static void main(String[] args) {

		String[] array = {"I 7", "I 5", "I -5","D 2"};
		int result[] = solution(array);

		System.out.print(result[0]+" "+result[1]);

	}

	static int[] solution(String[] operations) {
		int[] answer = {0,0};

		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 오름차순 정렬
		PriorityQueue<Integer> reverse_pq = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 정렬
		

		for(int i=0;i<operations.length;i++) {
			String[] str = operations[i].split(" ");
			String op = str[0];
			Integer num = Integer.parseInt(str[1]);
			if(op.equals("I")) { // 큐에 숫자 삽입
				pq.offer(num);
				reverse_pq.offer(num);
			}
			else {
				if(pq.isEmpty()) continue; // 빈 큐 삭제 명령어 무시
				if(num==1) { // 최댓값 삭제
					int max = reverse_pq.poll();
					pq.remove(max);
				}
				else if(num==-1) { // 최솟값 삭제
					int min = pq.poll();
					reverse_pq.remove(min);
				}
			}
		}

		if(pq.size()>=2) {
			answer[0] = reverse_pq.peek();
			answer[1] = pq.peek();
		}

		return answer;
	}

}

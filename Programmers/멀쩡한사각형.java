
public class 멀쩡한사각형 {

	public long solution(long w, long h) {
		long answer = w*h;

		long max = Math.max(w,h);
		long min = Math.min(w,h);

		while(min > 0){
			long temp = max;
			max = min;
			min = temp % min;
		}

		return answer - (h+w-max);
	}
}

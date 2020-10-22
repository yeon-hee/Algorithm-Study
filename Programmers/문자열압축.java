import java.util.*;

public class 문자열압축 {

	public int solution(String s) {
		int len = s.length();
		int answer = len;

		for(int i=1;i<=len/2;i++){
			String first = s.substring(0,i);
			String result = "";
			int count = 1;
			for(int j=i;j<=len-i;j+=i){
				String second = s.substring(j,j+i);
				if(first.equals(second)){ // 같으면
					count++;
				}
				else {
					if(count > 1 ) result += count;
					result += first;
					first = second;
					count = 1;
				}
			}
			if(count > 1) result += count;
			result += first;
			if(len % i !=0){
				int num = len % i;
				result += s.substring(len-num, len);
			}
			answer = Math.min(answer, result.length());
		}

		return answer;
	}

}

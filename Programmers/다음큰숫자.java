
public class 다음큰숫자 {

	public int solution(int n) {
		int answer = 0;

		int oneCnt = 0;
		String str = Integer.toBinaryString(n);
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='1') oneCnt++;
		}

		for(int i=n+1;i<2000000;i++){
			String num = Integer.toBinaryString(i);
			int cnt = 0;
			for(int j=0;j<num.length();j++){
				if(num.charAt(j)=='1') cnt++;
			}    
			if(oneCnt == cnt) {
				answer = i;
				break;
			}
		}

		return answer;
	}

}

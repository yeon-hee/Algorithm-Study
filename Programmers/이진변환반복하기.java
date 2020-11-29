
public class 이진변환반복하기 {

	public int[] solution(String s) {
		int[] answer = new int[2];

		int zeroCnt = 0;
		int turn = 0;

		while(true){
			if(s.equals("1")) break;
			String str = "";

			for(int i=0;i<s.length();i++){
				if(s.charAt(i)=='0') zeroCnt++;
				else str += s.charAt(i);
			}

			int len = str.length();
			s = Integer.toBinaryString(len);
			turn++;
		}

		answer[0] = turn;
		answer[1] = zeroCnt;

		return answer;
	}
}

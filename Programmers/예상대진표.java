
class 예상대진표{
	
	public int solution(int n, int a, int b)
	{
		int answer = 1;

		while(true){
			if((a+1)/2 == (b+1)/2) break;
			a = (a+1) / 2;
			b = (b+1) / 2;
			answer++;
		}

		return answer;
	}
}
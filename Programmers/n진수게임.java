
public class n진수게임 {

	public String solution(int n, int t, int m, int p) {
		String answer = "";
		String count = "0";
		int time = 0;
		int order = 1;
		int cnt = 0;
		boolean check = false;

		while(true){

			for(int i=0;i<count.length();i++){
				if(p==m){
					if(order % m == 0){ // 자기 차례
						if(Character.isAlphabetic(count.charAt(i))) 
							answer += Character.toUpperCase(count.charAt(i));
						else answer += count.charAt(i);
						cnt++;
					}
				}
				else {
					if(order % m == p){ // 자기 차례
						if(Character.isAlphabetic(count.charAt(i))) 
							answer += Character.toUpperCase(count.charAt(i));
						else answer += count.charAt(i);
						cnt++;
					}
				}
				order++;
				if(cnt == t) {
					check = true;
					break;
				}
			}

			if(check) break;
			time++;
			count = Integer.toString(time,n);     
		}

		return answer;
	}

}

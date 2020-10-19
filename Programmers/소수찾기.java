
public class 소수찾기 {

	static int len,answer,temp[];
	static boolean visited[],number[];
	public int solution(String numbers) {
		len = numbers.length();
		visited = new boolean[len];
		number = new boolean[9999999];
		temp = new int[len];

		for(int i=1;i<=len;i++){
			permutation(0,numbers,i);   
		}
		return answer;
	}

	static void permutation(int index, String numbers, int count){

		if(index==count){
			String str = "";
			for(int i=0;i<index;i++){
				str += numbers.charAt(temp[i]);
			}

			if(str.length() > 0){
				int num = Integer.parseInt(str);
				System.out.println(num);
				if(!number[num]){
					number[num] = true;
					if(isPrimary(num)) answer++;
				}   
			}

			return;
		}

		for(int i=0;i<len;i++){
			if(!visited[i]){
				visited[i] = true;
				temp[index] = i;
				permutation(index+1,numbers,count);
				visited[i] = false;
			}
		}
	}

	static boolean isPrimary(int number){

		if(number < 2) return false;

		for(int i=2;i*i<=number;i++){
			if(number%i == 0) return false;
		}
		return true;
	}

}

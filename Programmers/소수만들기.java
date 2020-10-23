
public class 소수만들기 {

	static int len,array[],answer;
	public int solution(int[] nums) {

		len = nums.length;
		array = new int[len];

		subset(0,0,nums);

		return answer;
	}

	static void subset(int index, int count, int[] nums){

		if(index==3){

			int number = 0;
			for(int i=0;i<index;i++){
				number += nums[array[i]];
			}

			if(isPrime(number)) answer++;

			return;
		}

		for(int i=count;i<len;i++){
			array[index] = i;
			subset(index+1,i+1,nums);
		}
	}

	static boolean isPrime(int number){

		for(int i=2;i*i<=number;i++){
			if(number % i == 0) return false;
		}

		return true;
	}

}

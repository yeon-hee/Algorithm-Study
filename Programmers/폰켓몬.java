import java.util.*;

public class 폰켓몬 {

	static int len,answer;
	public int solution(int[] nums) {

		len = nums.length;
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<len;i++){
			set.add(nums[i]);
		}

		if(set.size() >= (len/2)) answer = len/2;
		else answer = set.size();

		return answer;
	}

}

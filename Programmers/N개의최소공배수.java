import java.util.*;
public class N개의최소공배수 {
	
	public int solution(int[] arr) {
		int answer = 1;
		ArrayList<Integer> list = new ArrayList<>();

		while(true) {
			Arrays.sort(arr);
			int max = arr[arr.length-1];
			boolean check = false;

			for(int i=2;i<=max;i++){
				int count = 0;
				for(int j=0;j<arr.length;j++){
					if(arr[j]%i == 0) count++;
				}
				if(count >= 2) {
					list.add(i);
					for(int j=0;j<arr.length;j++){
						if(arr[j]%i == 0) arr[j] /= i;
					}
					check = true;
					break;
				}
			}

			if(!check){
				for(int i=0;i<arr.length;i++) list.add(arr[i]);
				break;
			}
		}

		for(int num : list){
			answer *= num;
		}

		return answer;
	}

}

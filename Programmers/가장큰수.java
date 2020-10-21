import java.util.*;

public class 가장큰수 {

	public String solution(int[] numbers) {
		String answer = "";

		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<numbers.length;i++){
			list.add(numbers[i]);
		}

		Collections.sort(list, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				String str1 = Integer.toString(o1);
				String str2 = Integer.toString(o2);
				return (str2+o1).compareTo(str1+o2);
			}
		});

		int temp = list.get(0);
		if(temp == 0) return "0";

		for(int j=0;j<numbers.length;j++){
			int tmp = list.get(j);
			String number = Integer.toString(tmp);
			answer += number;
		}

		return answer;
	}

}

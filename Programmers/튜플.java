import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class 튜플 {

	public int[] solution(String s) {

		String array[] = s.replaceAll("[{]"," ").replaceAll("[}]"," ").trim().split(" , ");
		Set<String> set = new HashSet<>();

		Arrays.sort(array, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2){
				return o1.length() - o2.length();
			}
		});

		int index = 0;
		int answer[] = new int[array.length];
		for(String arr: array){
			for(String str : arr.split(",")){
				if(!set.contains(str)){
					set.add(str);
					answer[index++] = Integer.parseInt(str);
				}
			}
		}

		return answer;
	}

}

import java.util.HashMap;

public class 뉴스클러스터링 {

	public int solution(String str1, String str2) {

		int answer = 0;
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		HashMap<String,Integer> map1 = new HashMap<>();
		HashMap<String,Integer> map2 = new HashMap<>();

		for(int i=0;i<str1.length()-1;i++){
			String str = "";
			if(!Character.isAlphabetic(str1.charAt(i)) || !Character.isAlphabetic(str1.charAt(i+1))) continue;
			str += str1.charAt(i);
			str += str1.charAt(i+1);
			if(map1.get(str)==null) map1.put(str,1);
			else map1.put(str,map1.get(str)+1);
		}

		for(int i=0;i<str2.length()-1;i++){
			String str = "";
			if(!Character.isAlphabetic(str2.charAt(i)) || !Character.isAlphabetic(str2.charAt(i+1))) continue;
			str += str2.charAt(i);
			str += str2.charAt(i+1);
			if(map2.get(str)==null) map2.put(str,1);
			else map2.put(str,map2.get(str)+1);
		}

		if(map1.size()==0 && map2.size()==0) return 65536;

		int min = 0; // 교집합
		int max = 0; // 합집합

		for(String str : map1.keySet()){
			int num1 = map1.get(str);
			if(map2.get(str)!=null){ // 겹치는게 있을 때
				int num2 = map2.get(str);
				min += Math.min(num1,num2);
				max += Math.max(num1,num2);
			} 
			else max += num1; // 합집합
		}

		for(String str : map2.keySet()) {
			if(map1.get(str)==null) max += map2.get(str);
		}        

		float result = (float)min / max;
		answer = (int)(result * 65536);
		return answer;
	}

}

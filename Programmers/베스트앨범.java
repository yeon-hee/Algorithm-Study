import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 베스트앨범 {
	
	static class Pair implements Comparable<Pair>{
		String gen; int music;
		public Pair(String gen, int music) {
			this.gen = gen;
			this.music = music;
		}
		@Override
		public int compareTo(Pair o) {
			return o.music -  this.music;
		}
	}
	
	public static void main(String[] args) {

		String[] array = {"classic","classic", "classic", "pop"};
		int[] play = {500,150,800,2500};
		
		int result[] = solution(array,play);
		for(int i=0;i<4;i++) System.out.print(result[i]+" ");
	}

	static int[] solution(String[] genres, int[] plays) {
		
		HashMap<String, Integer> map = new HashMap<>();
		int[] music = new int[genres.length];
		
		for(int i=0;i<genres.length;i++) {
			if(map.get(genres[i]) == null) map.put(genres[i], plays[i]);
			else {
				int sum = map.get(genres[i]);
				map.put(genres[i], sum+plays[i]);
			}
			music[i] = i;
		}
		
		for(int i=0;i<genres.length-1;i++) {
			for(int j=i+1;j<genres.length;j++) {
				if(plays[i] < plays[j]) {
					int temp = plays[i];
					plays[i] = plays[j];
					plays[j] = temp;
					
					String strTmp = genres[i];
					genres[i] = genres[j];
					genres[j] = strTmp;
					
					int muTmp = music[i];
					music[i] = music[j];
					music[j] = muTmp;
				}
			}
		}
		
		int[] answer = new int[map.size()*2];
		int index = 0;
		
		ArrayList<Pair> list = new ArrayList<>();
		for(String str : map.keySet()) {
			int num = map.get(str);
			list.add(new Pair(str,num));
		}
		
		Collections.sort(list);

		for(Pair a : list) {
			String str = a.gen;
			int count = 0;
			for(int j=0;j<genres.length;j++) {
				if(str.equals(genres[j])) {
					int order = music[j];
					answer[index++] = order;
					count++;
					if(count==2) break;
				}
			}
		}
	
		int result[] = new int[index];
		for(int i=0;i<index;i++) result[i] = answer[i];
		return result;
	}

}

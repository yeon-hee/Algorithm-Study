import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 카드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Long, Long> map = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			long num = Long.parseLong(br.readLine());
			if(map.get(num)==null) map.put(num, (long)1);
			else map.put(num, map.get(num)+1);
		}
		
		long max = Long.MIN_VALUE;
		long result = Long.MAX_VALUE;
		for(long a : map.keySet()) {
			if(max < map.get(a)) {
				max = map.get(a);
				result = a;
			} else if(max == map.get(a)) {
				result = Math.min(result, a);
			}
		}
		
		System.out.println(result);
	}

}

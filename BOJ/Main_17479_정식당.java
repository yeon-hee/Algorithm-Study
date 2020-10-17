import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_17479_정식당 {
	
	static int A,B,C,N;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		HashMap<String,Integer> menuA = new HashMap<>();
		HashMap<String,Integer> menuB = new HashMap<>();
		ArrayList<String> menuC = new ArrayList<>();
		
		for(int i=0;i<A;i++) {
			st = new StringTokenizer(br.readLine());
			String food = st.nextToken();
			int price = Integer.parseInt(st.nextToken());
			menuA.put(food, price);
		}
		
		for(int i=0;i<B;i++) {
			st = new StringTokenizer(br.readLine());
			String food = st.nextToken();
			int price = Integer.parseInt(st.nextToken());
			menuB.put(food, price);
		}
		
		
		for(int i=0;i<C;i++) {
			st = new StringTokenizer(br.readLine());
			String food = st.nextToken();
			menuC.add(food);
		}
		
		N = Integer.parseInt(br.readLine());
		long priceA = 0;
		long priceB = 0;
		int count = 0;
		
		for(int i=0;i<N;i++) {
			String food = br.readLine();
			if(menuA.get(food) != null) priceA += menuA.get(food);
			else if(menuB.get(food) != null) priceB += menuB.get(food);
			else count++;
		}
		
		if(priceB!=0 && priceA < 20000) System.out.println("No");
		else if(count!=0 && priceA + priceB < 50000) System.out.println("No");
		else if(count > 1) System.out.println("No");
		else System.out.println("Okay");
		
	}

}

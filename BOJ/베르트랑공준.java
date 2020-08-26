import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 베르트랑공준 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] array = new int[300000]; // 메모이제이션
		
		while(true) {
			
			int num = Integer.parseInt(br.readLine());
			int result = 0;
			if(num == 0) return;
			
			for(int i=num+1;i<=num*2;i++) {
				if(i==1) continue;
				if(array[i]==1) {
					result++;
					continue;
				}
				else if(array[i]==-1) continue;
				
				boolean check = true;
				for(int j=2;j*j<=i;j++) {
					if(i%j == 0) {
						check = false;
						break;
					}
				}
				if(check == true) {
					array[i] = 1;
					result++;
				} else array[i] = -1;
			}
			System.out.println(result);
		}
	}

}

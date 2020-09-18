import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1744_수묶기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int array[] = new int[N];
		int minus[] = new int[N];
		int result = 0;
		int index1 = 0;
		int index2 = 0;
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num<=0) minus[index1++] = num;
			else array[index2++] = num;
		}
		Arrays.sort(array,0,index2);
		Arrays.sort(minus);
		
		for(int i=0;i<index1;i++) {
			if(i+1<index1) {
				result += (minus[i]*minus[i+1]);
				i++;
			}
			else result += minus[i];
		}
		
		for(int i=index2-1;i>=0;i--) {
			if(i-1>=0) {
				if((array[i]*array[i-1]) > (array[i]+array[i-1])) result += (array[i]*array[i-1]);
				else result += (array[i]+array[i-1]);
				i--;
			}
			else result += array[i];
		}

		System.out.println(result);
	}

}

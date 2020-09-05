import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2670_연속부분최대곱 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		double array[] = new double[num];
		double max = 0;
		boolean check = false;
		
		for(int i=0;i<num;i++) {
			array[i] = Double.parseDouble(br.readLine());
			max = Math.max(max, array[i]);
		}
		
		double result = array[0];
		double sum = 1;
		for(int i=0;i<num;i++) {
			if(array[i]>=1) sum *= array[i];
			else {
				if(array[i] * sum > 1) {
					result = Math.max(result, sum);
					sum *= array[i];
					check = true;
				} else {
					result = Math.max(result, sum);
					sum = 1;
				}
			}
		}
		
		if(!check) result = max;
		else result = Math.max(result, sum);
		System.out.printf("%.3f",result);
		
	}

}


public class 현대오토에버_연습문제1 {
	
	public static void main(String[] args) {
		
		int array[] = {10,20,30,10,10,10};
		int result = 0;
		
		
		for(int i=0;i<array.length-1;i++) {
			if(array[i]==0) continue;
			int max = 0;
			int index = 0;
			for(int j=i+1;j<array.length;j++) {
				if(array[j]==0) continue;
				if(array[i] < array[j]) {
					if(max < array[j] - array[i]) {
						max = array[j] - array[i];
						index = j;
					}
				}
			}
			if(0<max) {
				array[i] = 0;
				array[index] = 0;
				result += max;
			}
		}
		
		System.out.println(result);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1316_그룹단어체커 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean array[] = new boolean[27];
		int result = 0;
		
		L:for(int i=0;i<N;i++) {
			String str = br.readLine();
			array = new boolean[27];
			for(int j=0;j<str.length()-1;j++) {
				
				if(str.charAt(j)==str.charAt(j+1)) continue;
				if(!array[str.charAt(j)-'a']) {
					array[str.charAt(j)-'a'] = true;
				}
				else continue L;
			}
			if(array[str.charAt(str.length()-1)-'a']) continue L;
			result++;
		}
		
		System.out.println(result);
	}

}

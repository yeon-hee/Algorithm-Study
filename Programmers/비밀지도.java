
public class 비밀지도 {

	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		int array1[][] = new int[n][n]; 
		int array2[][] = new int[n][n];

		for(int i=0;i<arr1.length;i++){
			String hash1 = Integer.toBinaryString(arr1[i]);
			String hash2 = Integer.toBinaryString(arr2[i]);
			int len1 = hash1.length();
			int len2 = hash2.length();

			for(int j=0;j<hash1.length();j++){
				array1[i][n-len1+j] = hash1.charAt(j)-'0';
			}
			for(int j=0;j<hash2.length();j++){
				array2[i][n-len2+j] = hash2.charAt(j)-'0';
			}
		}

		for(int i=0;i<n;i++){
			answer[i] = "";
			for(int j=0;j<n;j++){
				if(array1[i][j] + array2[i][j] >= 1) answer[i] += "#";
				else if(array1[i][j] + array2[i][j] == 0) answer[i] += " ";
			}
		}

		return answer;
	}

}

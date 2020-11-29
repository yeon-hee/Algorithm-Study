
public class 쿼드압축후개수세기 {

	public static void main(String[] args) {
		
		int array[][] = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
		int answer[] = solution(array);
		System.out.println(answer[0]+" "+answer[1]);
	}
	
	static int answer[];
	static int[] solution(int[][] arr) {
		answer = new int[2];
		int len = arr.length;

		dfs(0,0,len,arr);


		return answer;
	}

	static void dfs(int x, int y, int num, int arr[][]){

		boolean one = true;
		boolean zero = true;

		for(int i=x;i<x+num;i++){
			for(int j=y;j<y+num;j++){
				if(arr[i][j] == 0) one = false;
				else if(arr[i][j] == 1) zero = false;
			}
		}

		if(one){
			answer[1]++;
			return;
		}
		if(zero) {
			answer[0]++;
			return;
		}

		dfs(x,y,num/2,arr);
		dfs(x+num/2,y,num/2,arr);
		dfs(x,y+num/2,num/2,arr);
		dfs(x+num/2,y+num/2,num/2,arr);

	}

}

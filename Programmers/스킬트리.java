
public class 스킬트리 {

	static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		boolean check = false;
		L:for(int i=0;i<skill_trees.length;i++){ // 4번
			check = true;
			int array[] = new int[skill_trees[i].length()];
			for(int j=0;j<skill.length();j++){
				char ch = skill.charAt(j);
				for(int k=0;k<skill_trees[i].length();k++){
					if(skill_trees[i].charAt(k)==ch) array[k] = j+1;
				}
			}
			for(int j=0;j<array.length;j++) System.out.print(array[j]);
			System.out.println();

			for(int j=0;j<skill_trees[i].length();j++){ // 첫번째 순서 확인
				if(array[j]==0) continue;
				if(array[j]!=1) {
					check = false;
					continue L;
				}
				else if(array[j]==1) break;
			}

			int max = 0;
			for(int j=0;j<skill_trees[i].length();j++){
				if(array[j]==0) continue;
				if(max < array[j]) { // 1씩 차이나야 함
					if(array[j] != max+1) check= false;
					else max = array[j];
				}
				else if(max > array[j]) check = false;
			}
			if(check) answer++;
		}

		return answer;
	}
}

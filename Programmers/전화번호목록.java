import java.util.*;

public class 전화번호목록 {

	public static void main(String[] args) {

		String phone[] = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone));
	}

	 static boolean solution(String[] phone_book) {
	        boolean answer = true;
	        HashMap<String,Integer> map = new HashMap<>();
	        int min = Integer.MAX_VALUE;
	        for(int i=0;i<phone_book.length;i++){
	            String phone = phone_book[i];
	            map.put(phone,phone.length());
	            min = Math.min(min,phone.length());
	        }
	        
	        for(int i=0;i<phone_book.length;i++){
	            String phone = phone_book[i];
	            if(phone.length() == min) continue;
	            for(int j=min;j<phone.length();j++){
	                String subStr = phone.substring(0,j);
	                if(map.get(subStr) != null) {
	                    answer = false;
	                    break;   
	                }
	            }
	        }
	        return answer;
	    }

}

import java.util.*;

class 위장 {
    static Map<String, Integer> map = new HashMap<>();
    static int answer = 1;
    public int solution(String[][] clothes) {
        for(int i=0;i<clothes.length;i++){
            String name = clothes[i][0]; // value
            String category = clothes[i][1]; // key
            if(map.get(category)==null) map.put(category,1);
            else{
                int count = map.get(category);
                map.put(category, count+1);
            }
        }
        
        for(String key : map.keySet()){
            int num = map.get(key);
            System.out.println(num);
            answer *= (num+1);
        }
        return answer-1;
    }
}
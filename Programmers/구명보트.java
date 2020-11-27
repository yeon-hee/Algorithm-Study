
import java.util.*;

class 구명보트 {
    public int solution(int[] people, int limit) {
        int first = 0;
        int last = people.length-1;
        Arrays.sort(people);
        
        for(;first<last;last--){
            if(people[first] + people[last] <= limit){
                first++;
            }
        }
        
        return people.length - first;
    }
}
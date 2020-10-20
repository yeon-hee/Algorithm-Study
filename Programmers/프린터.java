import java.util.*;

class 프린터 {
    
	static class Pair {
        int x; int index;
        public Pair(int x, int index){
            this.x = x;
            this.index = index;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Pair> queue = new LinkedList<>();
        
        for(int i=0;i<priorities.length;i++){
            queue.offer(new Pair(priorities[i],i));
        }
        
        int count = 1;
        
        while(!queue.isEmpty()){
        
            Pair current = queue.poll();
            boolean check = true;
            for(Pair a : queue){
                int x = a.x;
                if(current.x < x){
                    check = false;
                    break;
                }
            }
            
            if(check){ // 여기서 빼야함
                if(current.index == location){
                    answer = count;
                    break;
                }
                else count++;
            }
            else queue.offer(current);
        }
        
        return answer;
    }
}
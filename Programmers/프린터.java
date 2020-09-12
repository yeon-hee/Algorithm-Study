import java.util.*;

class 프린터 {
    
    static class Pair{
        int x; int order;
        public Pair(int x, int order){
            this.x = x;
            this.order = order;
        }
    }
    
    static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Pair> queue = new LinkedList<>();
        Queue<Pair> temp = new LinkedList<>();
        int count = 1;
        boolean check = true;
        for(int i=0;i<priorities.length;i++) queue.offer(new Pair(priorities[i],i));
        
        L:while(!queue.isEmpty()){
            int max = 0;
            for(Pair a : queue) max = Math.max(max,a.x); // 최대값 구하기
            Pair first = queue.poll(); // 첫번째 꺼
            int x = first.x;
            check = true;
            while(!queue.isEmpty()){
                Pair a = queue.poll();
                int nx = a.x; // 이것이 크다면
                if(x!=max) { // 자기보다 큰 것이 있을 경우
                    check = false;
                    if(a.x == max) { // 꺼내려는 수 찾은 것 
                        if(a.order == location) {
                            answer = count; // 찾는 숫자이면
                            System.out.println(nx+" "+a.order);
                            //break L;
                        }
                        else {
                            System.out.println(nx+" "+a.order);
                            queue.offer(first);
                            for(Pair small : temp) queue.offer(small);
                            break;
                        }
                    }
                    else temp.offer(a);
                }
                else temp.offer(a); // 자신보다 큰게 없을 경우
            }
            if(check){ // 우선순위 높은게 없었을 경우 
                System.out.println(first.x+" "+first.order);
                if(first.order == location) answer = count;
                for(Pair small : temp) queue.offer(small);
            }
            count++;
            temp.clear();
        }
        
        return answer;
        
    }
}
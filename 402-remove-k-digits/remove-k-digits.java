class Solution {
    public String removeKdigits(String num, int k) {
        Deque <Integer> dq = new ArrayDeque<>();
        for(char c:num.toCharArray()){
            int d = c-'0';
            while(!dq.isEmpty() && dq.peekLast()>d && k>0){
                dq.pollLast();
                k--;
            }
            dq.offer(d);
        }
        while(!dq.isEmpty() && k>0){
            dq.pollLast();
            k--;
        }
        while(!dq.isEmpty() && dq.peekFirst()==0){
            dq.pollFirst();
        }
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()){
            sb.append(dq.pollFirst());
        }
        if(sb.length()==0) return "0";
        return sb.toString();
    }
}
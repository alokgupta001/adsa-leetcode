class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        char candidate = chars[0];
        sb.append(chars[0]);
        int cnt = 1;
        for(int i=1;i<chars.length;i++){
            if(chars[i]==candidate){
                cnt++;
            }else{
                if(cnt>1) sb.append(cnt);
                cnt=1;
                candidate = chars[i];
                sb.append(candidate);
            }
        }
        if(sb.charAt(sb.length()-1)==candidate ){
            if(cnt>1) sb.append(cnt);
        } 
        else{
            sb.append(candidate);
            sb.append(cnt);
        }
        int i=0;
        for(char c: sb.toString().toCharArray()){
            chars[i++] = c;
        }
        return sb.length();
    }
}
class Solution {
    static class SegmentTree{
        int n;
        long [] segTree;
        long [] lazy;
        SegmentTree(int idx){
            n=idx;
            segTree= new long[4*idx];
            lazy = new long[4*idx];
        }
        void push(int idx,int l,int r){
            if(lazy[idx]!=0){
                segTree[idx] = lazy[idx];
                if(l!=r){
                    lazy[2*idx+1] = lazy[idx];
                    lazy[2*idx+2] = lazy[idx];
                }
                lazy[idx]=0;
            }
        }
        long query(int idx,int l,int r,int ql,int qr){
            push(idx,l,r);
            if(ql>r || qr<l) return Integer.MIN_VALUE;
            if(ql<=l && qr>=r) return segTree[idx];
            int m = l+(r-l)/2;
            long left = query(2*idx+1,l,m,ql,qr);
            long right = query(2*idx+2,m+1,r,ql,qr);
            return Math.max(left,right);
        }
        void update(int idx,int l,int r,int ql,int qr,int val){
            push(idx,l,r);
            if(ql>r || qr<l) return;
            if(ql<=l && qr>=r){
                lazy[idx]=val;
                push(idx,l,r);
                return;
            }
            int m = l+(r-l)/2;
            update(2*idx+1,l,m,ql,qr,val);
            update(2*idx+2,m+1,r,ql,qr,val);
            segTree[idx]=Math.max(segTree[2*idx+1],segTree[2*idx+2]);
            return;
        }
    }
    public List<Integer> fallingSquares(int[][] positions) {
        HashSet<Integer> set = new HashSet<>();
        for( int[] pos : positions){
            set.add(pos[0]);
            set.add(pos[0]+pos[1]-1);
        }
        List<Integer> l1 = new ArrayList<>(set);
        Collections.sort(l1);
        Map<Integer,Integer> map = new HashMap<>();
        int idx=0;
        for(int num : l1){
            if(!map.containsKey(num)) map.put(num,idx++);
        }
        SegmentTree seg = new SegmentTree(idx);
        int max =0;
        List<Integer> ans = new ArrayList<>();
        for(int [] pos : positions){
            int left = pos[0];
            int height = pos[1];
            int currHeight = (int) seg.query(0,0,idx-1,map.get(left),map.get(left+height-1));
            int totalheight = height+currHeight;
            seg.update(0,0,idx-1,map.get(left),map.get(left+height-1),totalheight);
            
            max=Math.max(max,(int) seg.query(0,0,idx-1,0,idx-1));
            ans.add(max);
        }
        return ans;
    }
}
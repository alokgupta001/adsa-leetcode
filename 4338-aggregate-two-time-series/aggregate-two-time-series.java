class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        TreeSet<Integer> set1 = new TreeSet<>();
        TreeSet<Integer> set2 = new TreeSet<>();
        for(int[] series :series1){
            map1.put(series[0],series[1]);   
            set1.add(series[0]);
        }
        for(int[] series :series2){
            map2.put(series[0],series[1]);   
            set2.add(series[0]);;
        }
        int m = series1.length ;
        int n = series2.length;
        int i=0;
        int j = 0;
        List<List<Integer>> res = new ArrayList<>();
        while(i<m && j<n){
            int [] s1 = series1[i];
            int [] s2 = series2[j];
            if(!set1.contains(s1[0])){
                i++;
                continue;
            }
            if(!set2.contains(s2[0])){
                j++;
                continue;
            }
            if(s1[0]==s2[0]){
                res.add(new ArrayList<>(Arrays.asList(s1[0],s1[1]+s2[1])));
                set1.remove(s1[0]);
                set2.remove(s2[0]);
                i++;
                j++;
                
            }else if(s1[0]<s2[0]){
                int next = 0;
                if(set2.ceiling(s1[0])!=null) {
                    next = map2.get(set2.ceiling(s1[0]));
                    //set2.remove(next);
                }
                set1.remove(s1[0]);
                res.add(new ArrayList<>(Arrays.asList(s1[0],s1[1]+next)));
                i++;
            }else if(s1[0]>s2[0]){
                int next = 0;
                if(set1.ceiling(s2[0])!=null){
                    next = map1.get(set1.ceiling(s2[0]));
                    //set1.remove(next);
                } 
                set2.remove(s2[0]);
                res.add(new ArrayList<>(Arrays.asList(s2[0],s2[1]+next)));
                j++;
            }
        }
        while(i<m){
            int [] s1 = series1[i];
            
            if (set1.contains(s1[0])) {
                int next = 0;
                if (set2.ceiling(s1[0]) != null) {
                    next = map2.get(set2.ceiling(s1[0]));
                }
                res.add(new ArrayList<>(Arrays.asList(s1[0], s1[1] + next)));
                set1.remove(s1[0]);
            }
            i++;
        }
        while(j<n){
            int [] s1 = series2[j];
            
            if (set2.contains(s1[0])) {
                int next = 0;
                if (set1.ceiling(s1[0]) != null) {
                    next = map1.get(set1.ceiling(s1[0]));
                }
                res.add(new ArrayList<>(Arrays.asList(s1[0], s1[1] + next)));
                set2.remove(s1[0]);
            }
            j++;
        }
        
        return res;
    }
}
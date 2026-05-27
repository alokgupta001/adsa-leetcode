class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.putIfAbsent(arr[i],new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        q.offer(new int[]{0, 0});
        visited[0] = true;
        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int idx = curr[0];
            int steps = curr[1];

            if (idx == arr.length - 1) {
                return steps;
            }
            if (idx - 1 >= 0 && !visited[idx - 1]) {
                visited[idx - 1] = true;
                q.offer(new int[]{idx - 1, steps + 1});
            }
            if (idx + 1 < arr.length && !visited[idx + 1]) {
                visited[idx + 1] = true;
                q.offer(new int[]{idx + 1, steps + 1});
            }
            if (map.containsKey(arr[idx])) {

                for (int next : map.get(arr[idx])) {

                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(new int[]{next, steps + 1});
                    }
                }

                map.remove(arr[idx]);
            }
        }
        return -1;
    }
}
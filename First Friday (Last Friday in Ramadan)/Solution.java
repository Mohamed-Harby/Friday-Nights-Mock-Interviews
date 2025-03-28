// Problem Link: https://leetcode.com/problems/time-needed-to-inform-all-employees/

class Solution {
    List<ArrayList<Integer>> adj;
    int [] informTime;

    int dfs(int node) {
        if (adj.get(node).size() == 0) {
            return 0;
        }

        int maxSub = 0;
        for (int i : adj.get(node)) {
            int tempAns = dfs(i);
            maxSub = Math.max(tempAns, maxSub);
        }

        return informTime[node] + maxSub;
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adj.add(new ArrayList<Integer>());
        }


        for (int i = 0; i < manager.length; ++i) {
            if (manager[i] == -1) continue;
            adj.get(manager[i]).add(i);
        }

        this.informTime = informTime;
        return dfs(headID);

    }
}

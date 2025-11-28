package Tem;

public class KdivisibleComponents {

        private int cuts = 0;
        private int k;
        private long[] values;
        private java.util.List<Integer>[] adj;

        public int maxKDivisibleComponents(int n, int[][] edges, int[] valuesArr, int k) {
            this.k = k;
            this.values = new long[n];
            for (int i = 0; i < n; i++) this.values[i] = valuesArr[i];

            // build adjacency list
            adj = new java.util.ArrayList[n];
            for (int i = 0; i < n; i++) adj[i] = new java.util.ArrayList<>();
            for (int[] e : edges) {
                int a = e[0], b = e[1];
                adj[a].add(b);
                adj[b].add(a);
            }

            cuts = 0;
            // run DFS from node 0 (or any node)
            dfs(0, -1);

            // number of components = cuts + 1
            return cuts + 1;
        }

        // returns subtree sum modulo k (0..k-1) for the node's subtree
        private long dfs(int node, int parent) {
            long sum = values[node];
            for (int nei : adj[node]) {
                if (nei == parent) continue;
                long childMod = dfs(nei, node);
                sum += childMod; // childMod is actual child subtree sum or 0 after cut
            }

            // If subtree sum is divisible by k and it's not the whole tree (i.e., has a parent), we can cut here
            if (sum % k == 0) {
                if (parent != -1) {
                    cuts++;
                    // Return 0 to parent because this subtree is separated
                    return 0;
                } else {
                    // root: don't count as cut, but return 0 (root's remainder 0)
                    return 0;
                }
            }
            // Otherwise propagate remainder up
            return sum % k;
        }
    }


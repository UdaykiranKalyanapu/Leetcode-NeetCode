package Tem;
import java.util.*;
public class TwoEdits {


        // ---------- TrieNode: one node of the prefix tree ----------
        class TrieNode {
            TrieNode[] children; // 26 slots for 'a' to 'z'
            boolean isEnd; // true if this node marks the end of a dictionary word

            TrieNode() {
                children = new TrieNode[26];
                isEnd = false;
            }
        }

        // ---------- Trie: builds the dictionary as a tree ----------
        class Trie {
            private TrieNode root;

            // Constructor: insert all dictionary words
            public Trie(String[] words) {
                root = new TrieNode();
                for (String word : words) {
                    insert(word);
                }
            }

            // Insert a single word into the trie
            public void insert(String word) {
                TrieNode node = root;
                for (char c : word.toCharArray()) {
                    int index = c - 'a'; // 0 for 'a', 1 for 'b', ...
                    if (node.children[index] == null) {
                        node.children[index] = new TrieNode();
                    }
                    node = node.children[index];
                }
                node.isEnd = true; // mark the end of the word
            }

            // Return the root node so we can start traversal from outside
            public TrieNode getRoot() {
                return root;
            }
        }

        // ---------- Main method: find all queries that match within 2 edits ----------
        public List<String> twoEditWords(String[] queries, String[] dictionary) {
            List<String> res = new ArrayList<>();

            // Build a trie from the dictionary
            Trie trie = new Trie(dictionary);
            TrieNode root = trie.getRoot();

            // Check each query word individually
            for (String query : queries) {
                if (dfs(root, query, 0, 0)) { // start at root, position 0, 0 edits used
                    res.add(query);
                }
            }

            return res;
        }

        // ---------- DFS that allows at most 2 edits ----------
        // node: current trie node
        // query: the word we are trying to match
        // pos: current character index in query (0..len-1)
        // editsUsed: how many replacements have been made so far
        private boolean dfs(TrieNode node, String query, int pos, int editsUsed) {
            // If we already exceeded the allowed number of edits, stop this path
            if (editsUsed > 2) {
                return false;
            }

            // If we have processed all characters of the query,
            // then we succeed only if the current trie node represents a complete dictionary word.
            if (pos == query.length()) {
                return node.isEnd;
            }

            char currChar = query.charAt(pos);
            int index = currChar - 'a';

            // ---------- Option 1: exact match (no extra edit) ----------
            // Move to the child that corresponds to the same letter.
            if (node.children[index] != null) {
                if (dfs(node.children[index], query, pos + 1, editsUsed)) {
                    return true; // found a matching path
                }
            }

            // ---------- Option 2: replace current letter with any other letter (1 edit) ----------
            // Try every possible letter that is different from the original.
            for (int i = 0; i < 26; i++) {
                if (i != index && node.children[i] != null) {
                    // We use one more edit (editsUsed + 1) and move to that child
                    if (dfs(node.children[i], query, pos + 1, editsUsed + 1)) {
                        return true;
                    }
                }
            }

            // No path succeeded → this query cannot match any dictionary word within 2 edits
            return false;
        }
    }
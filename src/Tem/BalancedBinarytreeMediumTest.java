package Tem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class BalancedBinarytreeMediumTest {

    // Helper method to check if tree is balanced
    private int height(BalancedBinarytreeMedium.TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        if (left == -1) return -1;

        int right = height(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }

    private boolean isBalanced(BalancedBinarytreeMedium.TreeNode root) {
        return height(root) != -1;
    }

    private void inorder(BalancedBinarytreeMedium.TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    @Test
    void testBalanceBST() {
        BalancedBinarytreeMedium tree = new BalancedBinarytreeMedium();

        // Create a skewed BST: 1 -> 2 -> 3 -> 4 -> 5
        BalancedBinarytreeMedium.TreeNode root = new BalancedBinarytreeMedium.TreeNode(1);
        root.right = new BalancedBinarytreeMedium.TreeNode(2);
        root.right.right = new BalancedBinarytreeMedium.TreeNode(3);
        root.right.right.right = new BalancedBinarytreeMedium.TreeNode(4);
        root.right.right.right.right = new BalancedBinarytreeMedium.TreeNode(5);

        BalancedBinarytreeMedium.TreeNode balancedRoot = tree.balanceBST(root);

        // Check if balanced
        assertTrue(isBalanced(balancedRoot), "Tree should be balanced");

        // Check inorder remains sorted
        List<Integer> result = new ArrayList<>();
        inorder(balancedRoot, result);

        assertEquals(Arrays.asList(1,2,3,4,5), result);
    }
}

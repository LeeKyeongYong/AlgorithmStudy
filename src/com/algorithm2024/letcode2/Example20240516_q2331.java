package com.algorithm2024.letcode2;

import javax.swing.tree.TreeNode;

public class Example20240516_q2331 {

    class Solution {
        public boolean evaluateTree(TreeNode root) {
            if (func(root)==1) return true;
            return false;
        }
        int func (TreeNode root) {
            if (root.left==null && root.right==null) return root.val;
            int left = func(root.left);
            int right = func(root.right);
            if (root.val==2) return left | right;
            if (root.val==3) return left & right;
            return root.val;
        }
    }
}
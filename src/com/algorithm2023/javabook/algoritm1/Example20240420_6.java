package com.algorithm2023.javabook.algoritm1;

public class Example20240420_6 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class BSTFromArray {
        public TreeNode sortedArrayToBST(int[] arr) {
            if (arr == null || arr.length == 0) {
                return null;
            }

            return constructBST(arr, 0, arr.length - 1);
        }

        private TreeNode constructBST(int[] arr, int start, int end) {
            if (start > end) {
                return null;
            }

            // 중간 요소를 루트로 선택
            int mid = (start + end) / 2;
            TreeNode root = new TreeNode(arr[mid]);

            // 왼쪽 하위 배열을 사용하여 왼쪽 서브트리 생성
            root.left = constructBST(arr, start, mid - 1);

            // 오른쪽 하위 배열을 사용하여 오른쪽 서브트리 생성
            root.right = constructBST(arr, mid + 1, end);

            return root;
        }

        // 이진 트리를 중위 순회하여 값 출력 (테스트용)
        public void inorderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }

            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 5};

        BSTFromArray bstFromArray = new BSTFromArray();
        TreeNode root = bstFromArray.sortedArrayToBST(arr);

        // 중위 순회하여 BST의 요소 출력
        bstFromArray.inorderTraversal(root);
    }
}

package cn.offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 */
public class 二叉树的镜像 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public void Mirror(TreeNode root){
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if(root.left != null)
            Mirror(root.left);
        if(root.right != null)
            Mirror(root.right);
    }

    public TreeNode reverseLeftAndRight(TreeNode root){
        TreeNode node = root;
        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.poll();
            if(treeNode.left != null || treeNode.right != null){
                TreeNode tmp = treeNode.left;
                treeNode.left = treeNode.right;
                treeNode.right = tmp;
            }
            if(treeNode.left != null)
                stack.offer(treeNode.left);
            if(treeNode.right != null)
                stack.offer(treeNode.right);
        }
        return node;
    }

    public TreeNode initBinaryTree(TreeNode[] arr){
        if(arr.length != 0){
            for(int i = 0; i < arr.length; i++){
                if((i * 2 + 1) < arr.length){
                    arr[i].left = arr[i * 2 + 1];
                    arr[i].right = arr[i * 2 + 2];
                }else{
                    arr[i].left = null;
                    arr[i].right = null;
                }
            }
        }
        return arr[0];
    }

    public void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            System.out.print(curr.val + " ");
            if(curr.left != null)
                queue.offer(curr.left);
            if(curr.right != null)
                queue.offer(curr.right);
        }
    }

    public static void main(String[] args) {
        TreeNode[] treeNode = {new TreeNode(8) ,
                new TreeNode(6) ,
                new TreeNode(10) ,
                new TreeNode(5) ,
                new TreeNode(7) ,
                new TreeNode(9) ,
                new TreeNode(11) };

        二叉树的镜像 tree = new 二叉树的镜像();
        TreeNode t = tree.initBinaryTree(treeNode);
        tree.levelOrder(t);
        tree.Mirror(t);
    }

}

package cn.offer;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class 二叉树中和为某一值的路径 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> arrayList = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return arrayLists;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root, lastPopNode = null;
        while (!stack.isEmpty() || currentNode != null) {
            while (currentNode != null) {
                stack.push(currentNode);
                arrayList.add(currentNode.val);
                target -= currentNode.val;
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            if (currentNode.right == null || currentNode.right == lastPopNode) {
                if (currentNode.right == null)
                    if (target == 0)
                        arrayLists.add(new ArrayList<>(arrayList));
                arrayList.remove(arrayList.size() - 1);
                target += currentNode.val;
                lastPopNode = currentNode;
                currentNode = null;
            } else {
                stack.push(currentNode);
                currentNode = currentNode.right;
            }
        }
        return arrayLists;
    }

    /**
     * 初始化二叉树
     *
     * @param arr
     * @return
     */
    public TreeNode initTree(TreeNode[] arr) {
        if (arr.length != 0) {
            for (int i = 0; i < arr.length; i++) {
                if ((i * 2 + 1) < arr.length) {
                    arr[i].left = arr[i * 2 + 1];
                    arr[i].right = arr[i * 2 + 2];
                } else {
                    arr[i].left = null;
                    arr[i].right = null;
                }
            }
        }
        return arr[0];
    }

    /**
     * 层次遍历二叉树
     *
     * @param root
     */
    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null)
                queue.offer(curr.left);
            if (curr.right != null)
                queue.offer(curr.right);
        }
    }

    public static void main(String[] args) {
        TreeNode[] treeNode = {new TreeNode(10),
                new TreeNode(5),
                new TreeNode(12),
                new TreeNode(4),
                new TreeNode(7)};
        二叉树中和为某一值的路径 test = new 二叉树中和为某一值的路径();
        TreeNode root = test.initTree(treeNode);
        test.levelOrder(root);
        ArrayList<ArrayList<Integer>> list = test.FindPath(root, 22);
        System.out.println(list);
    }

}

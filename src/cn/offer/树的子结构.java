package cn.offer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class 树的子结构 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        boolean flag = false;
        //业务逻辑处理
        if (root1 != null && root2 != null) {
            if (root2.val == root1.val) {
                flag = compareBySubTree(root1, root2);
            }
            if (!flag)
                flag = HasSubtree(root1.left, root2);
            if (!flag)
                flag = HasSubtree(root1.right, root2);

        }
        return flag;
    }

    public boolean compareBySubTree(TreeNode root1, TreeNode root2) {
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.val != root2.val)
            return false;
        return compareBySubTree(root1.left , root2.left) && compareBySubTree(root1.right , root2.right);
    }


    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = null;
        C.right = null;
        D.left = null;
        D.right = null;
        E.left = null;
        E.right = null;
        TreeNode X = new TreeNode(1);
        TreeNode Y = new TreeNode(2);
        TreeNode Z = new TreeNode(5);
        X.left = Y;
        X.right = Z;
        Y.left = null;
        Y.right = null;
        Z.left = null;
        Z.right = null;
        树的子结构 result = new 树的子结构();
        System.out.println(result.HasSubtree(A, X));
    }
}

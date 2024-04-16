https://leetcode.com/problems/search-in-a-binary-search-tree/description/


//In binary tress, Tc for searching a node - O(N)
//In BST, Tc for searching a node - O(log2N) [Log base 2N]


class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null)  return null;

        if(root.val==val)   return root;

        if(root.val<val)
            return searchBST(root.right,val);
        else
            return searchBST(root.left,val);
    }
}
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)  return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level =0;
        while(q.size()!=0)
        {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<size; i++)
            {
                TreeNode a = q.remove();
                temp.add(a.val);
                if(a.left!=null)    q.add(a.left);
                if(a.right!=null)   q.add(a.right);
            }
            if(level%2==0)
                ans.add(temp);
            else
            {
                List<Integer> temp2 = new ArrayList<>();
                for(int i=temp.size()-1; i>=0; i--)
                {
                    temp2.add(temp.get(i));
                }
                ans.add(temp2);
            }
            level++;
        }
        return ans;
    }
}
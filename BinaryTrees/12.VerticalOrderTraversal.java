https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/submissions/1219135571

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
    int leftMostPos = 0;
    int rightMostPos = 0;
    public void traversal(TreeNode root, int pos)
    {
        if(root==null)  return;
        leftMostPos = Math.min(leftMostPos, pos);
        rightMostPos = Math.max(rightMostPos, pos);
        traversal(root.left,pos-1);
        traversal(root.right,pos+1);
    }
    class Pair implements Comparable<Pair>
    {
        TreeNode node;
        int vLevel;
        Pair(TreeNode node, int vLevel)
        {
            this.node = node;
            this.vLevel= vLevel;
        }
        public int compareTo(Pair o)
        {
            if(this.vLevel == o.vLevel)
                return this.node.val-o.node.val;
            else
                return this.vLevel-o.vLevel;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        traversal(root,0);
        List<List<Integer>> vo = new ArrayList<>();
        int noOfLevels = rightMostPos -leftMostPos +1;
        int vLevelOfRoot = -(leftMostPos);
        for(int i=0; i<noOfLevels; i++)
            vo.add(new ArrayList<>());
        PriorityQueue<Pair> que = new PriorityQueue<>();
        que.add(new Pair(root,vLevelOfRoot));
        while(que.size()!=0)
        {
            int size = que.size();
            PriorityQueue<Pair> cque = new PriorityQueue<>();
            while(size-->0)
            {
                Pair q = que.remove();
                vo.get(q.vLevel).add(q.node.val);
                if(q.node.left!=null)
                    cque.add(new Pair(q.node.left,q.vLevel-1));
                if(q.node.right!=null)
                    cque.add(new Pair(q.node.right,q.vLevel+1));
            }
            que=cque;
        }
        return vo;
    }
}
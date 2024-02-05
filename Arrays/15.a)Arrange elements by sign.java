https://leetcode.com/problems/rearrange-array-elements-by-sign/description/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pi =0;
        int ni =1;
        int ans[] = new int[nums.length];
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]>0)
            {
                ans[pi]=nums[i];
                pi=pi+2;
            }
            else
            {
                ans[ni]=nums[i];
                ni=ni+2;
            }
        }
        return ans;
    }
}
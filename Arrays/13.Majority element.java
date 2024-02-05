https://leetcode.com/problems/majority-element/description/

class Solution {
    public int majorityElement(int[] nums) {
        //Moore's Voting Algorithm

        int ans = 0; int ct=0;
        for(int i=0; i<nums.length; i++)
        {
            if(ct==0)
            {
                ans = nums[i];
                ct++;
            }else if(nums[i]==ans)
            {
                ct++;
            }else
            {
                ct--;
            }
        }
        int ct1 = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==ans)    ct1++;
        }
        if(ct1>nums.length/2)   return ans;

        return -1;
    }
}
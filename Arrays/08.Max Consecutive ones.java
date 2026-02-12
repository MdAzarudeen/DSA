https://leetcode.com/problems/max-consecutive-ones/description/

https://takeuforward.org/data-structure/count-maximum-consecutive-ones-in-the-array

class Solution {
    public int findMaxConsecutiveOnes(int[] nums)
    {
        int maxi = 0;   int ct=0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==1)
            {
                ct++;
                maxi = Math.max(maxi,ct);
            }else
            {
                ct=0;
            }
        }
        return maxi;
    }
}
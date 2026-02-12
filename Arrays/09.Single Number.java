https://leetcode.com/problems/single-number/description/

https://takeuforward.org/arrays/find-the-number-that-appears-once-and-the-other-numbers-twice

class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int ans =0;
        for(int i=0; i<n; i++)
            ans ^= nums[i];
        return ans;
    }
}

//can also use hashmap concept for this
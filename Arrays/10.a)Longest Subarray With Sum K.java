https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_6682399?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTabValue=PROBLEM

public class Solution {
    public static int longestSubarrayWithSumK(int []arr, long k) {
        //Tc: O(2N)  this will work for zeros and positive numbers in arrays
        int n = arr.length;
        int maxlen =0;
        int left = 0; int right =0;
        long sum = arr[0];
        while(right<n)
        {
            while(left<=right && sum>k)
            {
                sum -= arr[left];
                left++;
            }
            if(sum==k)
                maxlen = Math.max(maxlen, right-left+1);

            right++;
            if(right<n) sum+=arr[right];
        }
        return maxlen;
    }
}
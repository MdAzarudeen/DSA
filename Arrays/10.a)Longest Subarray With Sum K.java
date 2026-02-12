https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_6682399?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTabValue=PROBLEM

https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k

public class Solution {
    public static int longestSubarrayWithSumK(int []arr, long k) {
        //Tc: O(N)  this will work for zeros and positive numbers in arrays
        //  Sliding window approach
        int right =0; int left=0; long sum=0; int maxlen=0; int n= a.length;

        while(right<n) //traverse through array
        {
            sum += a[right];
            //shrink by left if sum>k
            while(left<=right && sum>k){
                sum-=a[left];
                left++;
            }

            //update maxlen if sum==k
            if(sum==k)
                maxlen = Math.max(maxlen,right-left+1);

            //expand right
            right++;
            // if(right<n)
            //     sum+=a[right];
        }
        return maxlen;
    }
}
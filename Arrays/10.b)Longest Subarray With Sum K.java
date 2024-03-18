https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_5713505?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTabValue=PROBLEM

import java.util.* ;
import java.io.*;
public class Solution {
    //Tc: O(N*N)  this will work for negative numbers in arrays also
    public static int getLongestSubarray(int []arr, int k) {
        int n = arr.length;
        int maxlen =0;
        int sum =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++)
        {
            sum += arr[i];

            if(sum==k)
                maxlen = Math.max(maxlen, i+1);

            int rem = sum-k;

            if(map.containsKey(rem))
            {
                int len = i-map.get(rem);
                maxlen = Math.max(maxlen, len);
            }
            if(!map.containsKey(sum))
                map.put(sum,i);
        }
        return maxlen;
    }
}
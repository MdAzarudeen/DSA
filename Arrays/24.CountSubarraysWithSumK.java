https://www.geeksforgeeks.org/problems/subarrays-with-sum-k/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_s

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findSubArraySum(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//Use Prefix sum for O(N)tc
// Tc: O(N log N)
// Sc: O(n)

class Solution
{
    static int findSubArraySum(int arr[], int n, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0;
        int ct =0;

        for(int i=0; i<n; i++)
        {
            prefixSum += arr[i];  // add current element to prefix Sum

            int rem = prefixSum - k;  // Calculate prefixSum-k

            if(map.containsKey(rem))
                ct += map.get(rem);  // Add the number of subarrays to be removed

            // Update the count of prefix sum in the map
            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        }

        return ct;
    }
}
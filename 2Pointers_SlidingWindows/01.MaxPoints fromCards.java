https://www.geeksforgeeks.org/problems/maximum-point-you-can-obtain-from-cards/1

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            long ans = obj.maxScore(a, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// Tc: O(2K)
//Sc: O(1)

class Solution {
    static long maxScore(int arr[], int n, int k) {

        int lsum =0; int rsum=0;

        for(int i=0; i<k; i++)
            lsum = lsum+arr[i];

        int ans = lsum;
        int r=n-1;
        for(int i=k-1; i>=0; i--)
        {
            rsum += arr[r]; r--;
            lsum = lsum - arr[i];
            ans = Math.max(ans,rsum+lsum);
        }
        return ans;
    }
}

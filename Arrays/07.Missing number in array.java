https://www.geeksforgeeks.org/problems/missing-number-in-array1416/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

        https://takeuforward.org/arrays/find-the-missing-number-in-an-array

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] array = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(array, n));
        }
    }
}
// } Driver Code Ends


// METHOD 1

class Solution {
    int missingNumber(int arr[], int n) {
        int sum1=0;
        sum1= (n*(n+1))/2; //This will overflow if n=10^5; hence use XOR method

        int sum2 = 0;
        for(int i=0; i<arr.length; i++)
            sum2 += arr[i];

        return sum1-sum2;
    }
}

// METHOD 2

class Solution {
    int missingNumber(int arr[], int n) {
        int xor1 = 0;
        for(int i=1; i<=n; i++)
            xor1 = xor1 ^ (i);  // will not overflow more than the original number
        xor1 = xor1 ^ n+1;
        int xor2 = 0;
        for(int i=0; i<arr.length; i++)
            xor2 = xor2 ^ arr[i];

        return xor1^xor2;
    }
}


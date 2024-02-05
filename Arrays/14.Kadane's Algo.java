https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1

//{ Driver Code Starts
import java.io.*;

import java.util.*;

class Main {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            //size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();

            //calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr, n));
        }
    }
}


// } Driver Code Ends

// LEARN BELOW 2 MODIFIED QNS ALSO

class Solution{
    long maxSubarraySum(int arr[], int n){
        //Kadane's algorithm
        long ans = Long.MIN_VALUE; long sum = 0;
        for(int i=0; i<n; i++)
        {
            sum += arr[i];
            if(sum>ans)
            {
                ans = sum;
            }
            if(sum<0)
            {
                sum=0;
            }
        }
        return ans;
    }
}

//IF THEY ASK TO CONSIDER AN EMPTY SET ALSO

 class Solution{
     long maxSubarraySum(int arr[], int n){
         //Kadane's algorithm
         long ans = Long.MIN_VALUE; long sum = 0;
         for(int i=0; i<n; i++)
         {
             sum += arr[i];
             if(sum>ans)
             {
                 ans = sum;
             }
             if(sum<0)
             {
                 sum=0;
             }
         }
         return ans>0 ? ans: 0;
     }
 }

//IF THEY ASK TO PRINT THE SUBARRAY WHICH GIVES MAX SUM
 class Solution{
     long maxSubarraySum(int arr[], int n){
         //Kadane's algorithm
         long ans = Long.MIN_VALUE; long sum = 0;
         int tempSt = 0; int st=0; int ed=0;
         for(int i=0; i<n; i++)
         {
             if(sum==0)  tempSt=i;
             sum += arr[i];
             if(sum>ans)
             {
                 ans = sum;
                 st = tempSt;
                 ed=i;
             }
             if(sum<0)
             {
                 sum=0;
             }
         }
         System.out.println(st+" "+ed);
         return ans;
     }
 }
https://www.geeksforgeeks.org/problems/minimum-number-in-a-sorted-rotated-array-1587115620/1?page=1&category=Binary%20Search&sortBy=submissions

//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Array
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");

            int arr[] = new int[n];

            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st[i]);

            System.out.println(new Solution().minNumber(arr,0,n-1));
        }
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find the minimum element in sorted and rotated array.
    static int minNumber(int arr[], int low, int high)
    {
        int ans = Integer.MAX_VALUE;
        while(low<=high)
        {
            // if the search space is already sorted
            if(arr[low]<=arr[high])
            {
                ans = Math.min(ans,arr[low]);
                break;
            }
            int mid = (low+high)/2;
            //if left-half is sorted, take the mini and move to right half
            if(arr[low]<=arr[mid])
            {
                ans = Math.min(ans,arr[low]);
                low = mid+1;
            }
            //if right-half is sorted, take the mini and move to left half
            else
            {
                ans = Math.min(ans,arr[mid]);
                high = mid-1;
            }
        }
        return ans;
    }
}
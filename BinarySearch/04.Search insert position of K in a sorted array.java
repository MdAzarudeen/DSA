https://www.geeksforgeeks.org/problems/search-insert-position-of-k-in-a-sorted-array/1

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;

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
            System.out.println(ob.searchInsertK(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int searchInsertK(int arr[], int n, int x)
    //Lower Bound Algo..
    {
        int low = 0; int high = n-1;
        int ans = n;
        while(low<=high)
        {
            int mid = (low+high)/2;

            if(arr[mid]>=x)
            {
                ans = mid;
                high = mid-1;
            }else
            {
                low = mid+1;
            }
        }
        return ans;
    }
}
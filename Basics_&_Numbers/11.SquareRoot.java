https://www.geeksforgeeks.org/problems/square-root/1

//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends



class Solution
{
    long floorSqrt(long n)
    {
        if (n < 2) return n;

        long low = 1; long high = n;
        while (low <= high)
        {
            long mid = (low + high) / 2;
            if (mid * mid == n)
                return mid;
            else if (mid * mid < n)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return high;
    }
}

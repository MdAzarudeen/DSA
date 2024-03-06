https://www.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1

//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                    matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans)
                System.out.print(val+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    // Right --> Bottom --> Left -->  Top
    static ArrayList<Integer> spirallyTraverse(int arr[][], int n, int m)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int top = 0; int bottom = n-1;
        int left = 0; int right = m-1;
        while(top<=bottom && left<=right)
        {
            for(int i=left; i<=right; i++)
            {
                ans.add(arr[top][i]);
            }
            top++;
            for(int i=top; i<=bottom; i++)
            {
                ans.add(arr[i][right]);
            }
            right--;
            if(top<=bottom)
            {
                for(int i=right; i>=left; i--)
                {
                    ans.add(arr[bottom][i]);
                }
                bottom--;
            }
            if(left<=right)
            {
                for(int i=bottom; i>=top; i--)
                {
                    ans.add(arr[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}

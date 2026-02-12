https://www.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            int matrix[][] = new int[n][n];
            String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(st[k++]);
            }
            Solution ob = new Solution();
            ob.rotateby90(matrix, n);
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                    System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int arr[][], int n)
    {
        int m = arr[0].length;
        //Transpose
        for(int i=0; i<n; i++)
        {
            for(int j=i; j<m; j++)
            {
                int temp = arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        // Reverse
        for(int j=0; j<m; j++)
        {
            for(int i=0; i<n/2; i++)
            {
                int temp = arr[i][j];
                arr[i][j]=arr[n-1-i][j];
                arr[n-1-i][j]=temp;
            }
        }
//another way to reverse
        for(int i=0; i<n; i++)
        {
            int left=0; int right=n-1;
            while(left<right){
                int temp = mat[left][i];
                mat[left][i]=mat[right][i];
                mat[right][i]=temp;
                left++;
                right--;
            }
        }
    }
}
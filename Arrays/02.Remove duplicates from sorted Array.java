https://www.geeksforgeeks.org/problems/remove-duplicate-elements-from-sorted-array/1?itm_source=geeksforgeeks&itm_medium=Article&itm_campaign=bottom_sticky_on_Article


        https://takeuforward.org/data-structure/remove-duplicates-in-place-from-sorted-array

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for(int i=0; i<N; i++)
                a[i] = sc.nextInt();

            Solution g = new Solution();
            int n = g.remove_duplicate(a,N);

            for(int i=0; i<n; i++)
                System.out.print(a[i]+" ");
            System.out.println();
            T--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int remove_duplicate(int arr[],int n){
        int i = 0;
        for(int j=1; j<n; j++)
        {
            if(arr[i]!=arr[j])
            {
                arr[i+1]=arr[j];
                i++;
            }
        }
        return i+1;
    }
}

//Solution 2

class Solution {
    ArrayList<Integer> removeDuplicates(int[] arr) {
        ArrayList<Integer> sol = new ArrayList<>();
        sol.add(arr[0]);
        int i=0;
        for(int j=1; j<arr.length; j++){
            if(arr[i]!=arr[j])  {
                sol.add(arr[j]);
                arr[i+1] = arr[j];
                i++;
            }
        }
        return sol;
    }
}
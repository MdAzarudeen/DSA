https://www.geeksforgeeks.org/problems/fruit-into-baskets-1663137462/1

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] fruits = new int[N];
            for (int i = 0; i < N; i++) fruits[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.totalFruits(N, fruits);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// //Tc: O(N), Sc: O(1)

class Solution {
    public static int totalFruits(int n, int[] arr) {
        int l=0; int r=0; int ans=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(r<n)
        {
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            while(map.size()>2)
            {
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])==0)   map.remove(arr[l]);
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}
https://www.geeksforgeeks.org/problems/length-of-the-longest-substring3036/1

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//Tc: O(N), Sc: O(N)


class Solution{
    int longestUniqueSubsttr(String s){
        HashSet<Character> set = new HashSet<>();
        int n= s.length();
        int ans =0; int i=0; int j=0;
        while(i<n && j<n)
        {
            if(!set.contains(s.charAt(j)))
            {
                set.add(s.charAt(j));
                ans = Math.max(ans, j-i+1);
                j++;
            }
            else
            {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}
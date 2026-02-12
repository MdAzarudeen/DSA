https://www.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab

//{ Driver Code Starts
//Initial Template for Java

import java.math.*;
import java.util.*;
import java.io.*;

class Driverclass
{
    // Driver Code
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreElements()){
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); }
            }
            return st.nextToken();
        }

        String nextLine(){
            String str = "";
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); }
            return str;
        }

        Integer nextInt(){
            return Integer.parseInt(next());
        }
    }

    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();

        while(t>0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];

            for(int i=0; i<n; i++)
                a[i] = sc.nextInt();
            out.println(new Solution().findLongestConseqSubseq(a, n));
            t--;
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //if we avoid sort function, we need to use Set
    static int findLongestConseqSubseq(int arr[], int n)
    {
        Arrays.sort(arr);
        int lastSmaller = Integer.MIN_VALUE;
        int longest = 1;
        int ct = 0;
        for(int i=0; i<n; i++)
        {
            if(arr[i]-1==lastSmaller)
            {
                ct++;
                lastSmaller = arr[i];
            }
            else if(arr[i]!=lastSmaller)
            {
                ct = 1;
                lastSmaller = arr[i];
            }
            longest = Math.max(longest,ct);
        }
        return longest;
    }
}

//without sorting
class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int a: arr) set.add(a);
        int longest = 1; int ct=0; int x=0;
        for(int num: set){
            if(!set.contains(num-1)){
                ct=1;
                x=num;
            }
            while(set.contains(x+1)){
                ct++;
                x++;
            }
            longest =Math.max(longest,ct);
        }
        return longest;
    }
}
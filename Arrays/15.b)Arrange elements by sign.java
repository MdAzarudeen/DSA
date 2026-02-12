https://www.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab

//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            if(arr[i]>=0)
                pos.add(arr[i]);
            else
                neg.add(arr[i]);
        }

        int i=0; int j=0; int idx =0;
        while(i<pos.size()  &&  j<neg.size())
        {
            arr[idx]=pos.get(i);
            idx++; i++;
            arr[idx]=neg.get(j);
            idx++; j++;
        }
        while(i<pos.size())
        {
            arr[idx]=pos.get(i);
            idx++; i++;
        }
        while(j<neg.size())
        {
            arr[idx]=neg.get(j);
            idx++; j++;
        }
    }
}


class Solution {
    void rearrange(ArrayList<Integer> arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        int n=arr.size();

        for(int i=0; i<n; i++)
        {
            if(arr.get(i)>=0)    pos.add(arr.get(i));
            else    neg.add(arr.get(i));
        }

        int i=0; int j=0;  int idx=0;
        while(i < pos.size() && j < neg.size()) {
            arr.set(idx++, pos.get(i++));
            arr.set(idx++, neg.get(j++));
        }

        // remaining positives
        while(i < pos.size()) {
            arr.set(idx++, pos.get(i++));
        }

        // remaining negatives
        while(j < neg.size()) {
            arr.set(idx++, neg.get(j++));
        }
    }
}
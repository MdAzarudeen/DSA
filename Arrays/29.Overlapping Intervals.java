https://www.geeksforgeeks.org/problems/overlapping-intervals--170633/1

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

//Time Complexity: O(N*logN) + O(N),
//Sc: O(N)


class Solution
{
    public int[][] overlappedInterval(int[][] arr)
    {
        int n = arr.length;
        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int[]a, int[]b){
                return a[0]-b[0];
            }
        });
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++)
        {
//if the current interval does not lie in the last interval:
            if(ans.isEmpty() || arr[i][0]>ans.get(ans.size()-1).get(1))
            {
                ans.add(Arrays.asList(arr[i][0],arr[i][1]));
            }
//if the current interval lies in the last interval
            else
            {
                ans.get(ans.size()-1).set(1,Math.max(ans.get(ans.size()-1).get(1),
                        arr[i][1]));
            }
        }
        int rows = ans.size();
        int cols = ans.get(0).size();

        int[][] array = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = ans.get(i).get(j);
            }
        }
        return array;
    }
}
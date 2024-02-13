https://leetcode.com/problems/rotate-image/

class Solution {
    public void rotate(int[][] arr) {
        int n = arr.length;
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
        //Reverse
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m/2; j++)
            {
                int temp = arr[i][j];
                arr[i][j]=arr[i][n-1-j];
                arr[i][n-1-j]=temp;
            }
        }

    }
}
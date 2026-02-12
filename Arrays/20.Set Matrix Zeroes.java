https://leetcode.com/problems/set-matrix-zeroes/

class Solution {
    public void setZeroes(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[]row = new int[n];
        int[]col = new int[m];

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(arr[i][j]==0)
                {
                    row[i]=1;
                    col[j]=1;
                }
            }
        }

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(row[i]==1 || col[j]==1)
                    arr[i][j]=0;
            }
        }
    }
}


//without extra space for 2 arrays
class Solution {
    public void setZeroes(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        boolean firstRowZero = false; boolean firstColZero = false;
        for(int i=0; i<m; i++){
            if(arr[0][i]==0)   {
                firstRowZero=true; break;}
        }

        for(int i=0; i<n; i++){
            if(arr[i][0]==0)  {
                firstColZero=true; break; }
        }

        for(int i=1; i<n; i++)
        {
            for(int j=1; j<m; j++)
            {
                if(arr[i][j]==0){
                    arr[0][j]=0;
                    arr[i][0]=0;
                }
            }
        }

        for(int i=1; i<n; i++)
        {
            for(int j=1; j<m; j++)
            {
                if(arr[i][0]==0 || arr[0][j]==0){
                    arr[i][j]=0;
                }
            }
        }

        if(firstRowZero){
            for(int i=0; i<m; i++){
                arr[0][i]=0;
            }
        }

        if(firstColZero){
            for(int i=0; i<n; i++){
                arr[i][0]=0;
            }
        }
    }
}
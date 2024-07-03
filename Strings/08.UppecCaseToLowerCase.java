ASCII values  of alphabets: A – Z = 65 to 90, a – z = 97 to 122

        https://www.geeksforgeeks.org/problems/lower-case-to-upper-case3410/1

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GFG{
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.to_upper(str));
        }
    }
}
// } Driver Code Ends


class Solution
{
    String to_upper(String str)
    {
        String ans = "";
        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            ans += Character.toUpperCase(ch);
        }
        return ans;
    }
}

//Upper case to Lowe case -> ans += Character.toLowerCase(ch);

class Solution
{
    String to_upper(String str)
    {
        char[]ch = str.toCharArray();
        for(int i=0; i<str.length(); i++)
        {
            ch[i]^=(1<<5);
        }
        return new String(ch);
    }
}

// For each character, Si, do Si =  Si ^ (1 << 5).
// Si ^ (1 << 5) toggles the 5th bit which means 97 will become 65 and 65 will become 97:
// 65 ^ 32 = 97
// 97 ^ 32 = 65

// 1<<5-> 32
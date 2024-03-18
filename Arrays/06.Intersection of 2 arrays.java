https://www.codingninjas.com/studio/problems/intersection-of-2-arrays_1082149?leftPanelTabValue=SUBMISSION

import java.util.* ;
import java.io.*;
public class Solution
{
    //Tc: O(N+M)
    //Sc: O(1) best case // O(N+M) in worst case
    public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> a, int n, ArrayList<Integer> b, int m)
    {
        int i=0;
        int j=0;
        ArrayList<Integer> list = new ArrayList<>();
        while(i<n && j<m)
        {
            if(a.get(i)<b.get(j))   i++;
            else if(b.get(j)<a.get(i))  j++;
            else
            {
                list.add(a.get(i));
                i++;
                j++;
            }
        }
        return list;
    }
}

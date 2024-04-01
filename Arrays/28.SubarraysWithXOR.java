https://www.codingninjas.com/studio/problems/count-subarrays-with-given-xor_1115652?leftPanelTabValue=PROBLEM

//https://takeuforward.org/data-structure/count-the-number-of-subarrays-with-given-xor-k/#google_vignette

//Time Complexity: O(N) or O(N*logN) depending on which map data structure we are using,
//SC: O(N)



// Question: Why do we need to set the value of 0 beforehand?
// Let’s understand this using an example.
// Assume the given array is [3, 3, 1, 1, 1] and k is 3.
// Now, for index 0, we get the total prefix XOR as 3, and k is also 3.
// So, the prefix XOR xr^k will be = 3^3 = 0.
// Now, if the value is not previously set for the key 0 in the map,
// we will get the default value 0 and we will add 0 to our answer.



import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
    public static int subarraysXor(ArrayList<Integer> arr, int k) {
        int n = arr.size();
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1); //setting the value of 0.

        int ct=0; int xr=0;
        for(int i=0; i<n; i++)
        {
            xr = xr ^ arr.get(i);
            //By formula: x = xr^k:
            int x = xr ^ k;
            if(map.containsKey(x))
                ct+=map.get(x);

            map.put(xr,map.getOrDefault(xr,0)+1);
        }
        return ct;
    }
}
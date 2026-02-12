https://leetcode.com/problems/two-sum/description/

https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-sum-exists-in-array

class Solution {
    public int[] twoSum(int[] arr, int x)
    {
        //Tc: O(N)
        //Sc: O(N)
        int[]ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++)
        {
            int diff = x-arr[i];

            if(map.containsKey(diff))
            {
                ans[0]=map.get(diff);
                ans[1]=i;
                break;
            }else
                map.put(arr[i],i);
        }
        return ans;
    }
}
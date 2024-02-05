https://leetcode.com/problems/two-sum/description/

class Solution {
    public int[] twoSum(int[] arr, int x)
    {
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
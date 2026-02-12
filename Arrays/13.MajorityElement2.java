https://leetcode.com/problems/majority-element-ii/
https://takeuforward.org/data-structure/majority-elementsn-3-times-find-the-elements-that-appears-more-than-n-3-times-in-the-array


//To understand why there can't be more than two majority elements (elements that appear more than n/3 times) in an array of size n, let's consider the following reasoning:
//A majority element must appear more than n/3 times. Let’s assume there are more than two majority elements, say A, B, and C.
//The combined frequency of these three elements would be: frequency of A + frequency of B + frequency of C > n/3 + n/3 + n/3 = n.
//Since the total occurrences of all elements cannot exceed n (the size of the array), the combined frequency of any three elements each appearing more than n/3 times would exceed the total size of the array, leading to a contradiction.
//Therefore, it is mathematically impossible to have more than two elements that each appear more than n/3 times in the array.


//Better Solution

class Solution {
    public List<Integer> majorityElement(int[] nums) {

// Time Complexity: O(N*logN), where N = size of the given array.
// Reason: We are using a map data structure. Insertion in the map takes logN time. And we are doing it for N elements. So, it results in the first term O(N*logN).
// If we use unordered_map instead, the first term will be O(N) for the best and average case and for the worst case, it will be O(N2).
// Sc:O(N)

        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int z = (int)(n/3)+1;
        for(int i=0; i<n; i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])==z)
                list.add(nums[i]);
            if(list.size()==2)
                break;
        }
        return list;
    }
}

//Optimal Solution

//Extended Moore's voting algo

//Tc: O(N), Sc: O(1)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int el1 = Integer.MIN_VALUE; int el2 = Integer.MIN_VALUE;
        int ct1= 0; int ct2= 0;
        for(int i=0; i<n; i++)
        {
            if(ct1==0 && nums[i]!=el2)
            { ct1=1; el1= nums[i]; }
            else if(ct2==0 && nums[i]!=el1)
            { ct2=1; el2= nums[i]; }
            else if(nums[i]==el1)   ct1++;
            else if(nums[i]==el2)   ct2++;
            else
            { ct1--; ct2--;}
        }

        ct1=0; ct2=0;
        for(int i=0; i<n; i++)
        {
            if(nums[i]==el1)    ct1++;
            else if(nums[i]==el2)   ct2++;
        }
        int z = (int)(n/3)+1;
        List<Integer> list = new ArrayList<>();
        if(ct1>=z)  list.add(el1);
        if(ct2>=z)  list.add(el2);

        return list;

    }
}

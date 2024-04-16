https://www.geeksforgeeks.org/problems/floor-in-bst/1

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class Node {
    int data;
    Node right;
    Node left;

    Node(int val) {
        data = val;
        right = null;
        left = null;
    }
}

class GFG {

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) {
            return new Node(val);
        }

        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }

        return tree;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            Node root = null;
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int k = sc.nextInt();
                root = insert(root, k);
            }

            int s = sc.nextInt();

            Solution obj = new Solution();
            int ans = obj.floor(root, s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// The ceil function returns the smallest integer value which is greater than or equal to the specified
// number, whereas the floor function returns the largest integer value which is
// less than or equal to the specified number.

// Tc - O(log2N) [Log base 2N]


class Solution {
    public static int floor(Node root, int key) {
        int floor = -1;
        while(root!=null)
        {
            if(key==root.data)
            {
                floor = root.data;
                return floor;
            } else if(key>root.data)
            {
                floor = root.data;
                root = root.right;
            }else
            {
                root= root.left;
            }
        }
        return floor;
    }
}
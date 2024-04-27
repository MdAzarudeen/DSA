https://www.geeksforgeeks.org/problems/prime-number2314/1
//Tc:O(N), Sc: O(1)

class Solution{
    static int isPrime(int n){
        if(n<=1)    return 0;

        for(int i=2; i<n; i++)
        {
            if(n%i==0)  return 0;
        }

        return 1;
    }
}

//Tc:O(√n), Sc: O(1)

class Solution{
    static int isPrime(int n){
        if(n<=1)    return 0;

        for(int i=2; i<=Math.sqrt(n); i++)
        {
            if(n%i==0)  return 0;
        }

        return 1;
    }
}
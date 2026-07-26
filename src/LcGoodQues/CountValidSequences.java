package LcGoodQues;

// ques : https://leetcode.com/problems/count-valid-sequences/

// Stars and Bars technique

// distribute n tofee in n children -> n+k-1 C k-1 = (n+k-1)!/ (k-1)!(n-k-1 -(k-1))!
// == (n+k-1)!/ (k-1)!n!
// ------------------------------------------------------------
// divide operation with modular operation not possible
// i.e 3/2 % 7 => 1.5 % 7 ===> Divide operation can cause decimal value

// do 3 * (2)pow-1 % 7
// inverse modulo
// lets take 2pow-1 ==> Modular inverse of 2 MOD 7 = P
// 3*P %7 => possible

///  Fermat Little Theorem

// Modular inverse of a MOD m ==> aPow(m-2) % M
    // 2Pow(-1) % 7 ===> 2Pow(7-2) % 7 ==> 2Pow5 % 7
    // 5Pow(-1) % 4 ====> 5Pow(4-2) %4 ==> 5Pow2 % 4

    // calculate aPow(m-2) by binary exponentiation -> Log(n)

///  nCr % MOD = n! * (modulo inverse of r! * (n-r)! mod MOD)!


public class CountValidSequences {

    static final int MOD = (int) 1e9 + 7;

    public int countValidSequences(int n, int k) {
        int max = n;
        long[] fact = new long[max+1];
        fact[0] = 1;
        for(int i=1; i<=max; i++){
            fact[i] = (fact[i-1] * i)%MOD;
        }

        long[] invFact = new long[max + 1];
        invFact[max] = modPow(fact[max], MOD - 2);
        for (int i = max - 1; i >= 0; i--)
            invFact[i] = invFact[i + 1] * (i + 1) % MOD; // or  invFact[i - 1] = invFact[i] * i % MOD;


        long odd = 0;
        long totalPossibleWays = nCrWithComputedInvFactorial(n-1,k-1,fact,invFact);
        if(((n-k)&1)==0){
            int m = (n + k - 2) / 2;
            odd = nCrWithComputedInvFactorial(m, k - 1, fact, invFact);
        }
        return (int)((totalPossibleWays - odd + MOD) % MOD);
    }

    private long nCrWithComputedInvFactorial(int n, int r, long[] fact, long[] invFact) {
        if(r<0 || r>n)
            return 0;
        long ans = fact[n];
        ans = (ans * invFact[r]) % MOD;
        ans = (ans * invFact[n - r]) % MOD;
        return ans;
    }

    // Binary Exponentiation
    private long modPow(long a, long b) {
        if (b == 0)
            return 1;
        if(b==1)
            return a%MOD;
        long half = modPow(a,b/2);
        long ans = (half * half) % MOD;
        if((b&1) == 1){
            ans = (ans * a) % MOD;
        }
        return ans;
    }


    // a/b % MOD = (a * bPow(MOD-2)) % MOD
    private long nCr(int n, int r, long[] fact) {
        if(r<0 || r>n)
            return 0;
        long a = fact[n];
        long b = (fact[r] * fact[n-r]) % MOD;
        return (a * modPow(b, MOD - 2)) % MOD;
    }

    public static void main(String[] args) {

    }
}

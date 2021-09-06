package leetcode_topInterview;

public class CountPrimes_204 {

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int res = 1;
        for (int i = 3; i <n; i++) {
            if (isPrime(i)) {
                res++;
            }
        }
        return res;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CountPrimes_204 offer = new CountPrimes_204();
        int res = offer.countPrimes(2);
        System.out.println(res);
    }

}

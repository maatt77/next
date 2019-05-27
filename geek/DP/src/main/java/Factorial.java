public class Factorial {

//    Simple recursion
    public static Integer factorialRecursion(Integer n){

//        N! = n*(n-1)!
        if (n==1) {
            return 1;
        }
        return n*factorialRecursion(n-1);
    }

    public static Integer factorialTabulation(Integer n ) {

        Integer[] results = new Integer[n];
        results[0]=1;

        for (int i = 1; i < n; i++) {
            results[i] = results[i-1]*(i+1);
        }

        return results[n-1];

    }
}

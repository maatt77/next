public class Fibonachi {


    public static Integer fibRecursion(Integer n ) {
        if (n<=1){
            return n;
        }
        return fibRecursion(n-1) + fibRecursion(n-2);
    }

    public static Integer fibMemo(Integer n ) {

        Integer[] mem = new Integer[n];


    }
}

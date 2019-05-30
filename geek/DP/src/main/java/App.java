import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        Integer n = 10;
        Integer fact = Fibonachi.fibRecursion(n);
        Fibonachi fib = new Fibonachi();
//
        Integer fact2 = fib.fibMemo(n);
        Integer fact3 = fib.fibBottomUp(n);


        System.out.println(fact);
        System.out.println(fact2);
        System.out.println(fact3);

        Integer set[] = {3, 34, 4, 12, 5, 200,4,5,6,7,8,9,10,33,87,23,445,2,34,45,345,3432423};
        int sum = 2000;
        int setLen = set.length;

        SumSubset ss = new SumSubset();

        Map<String,Boolean> lookup = new HashMap<String, Boolean>();

        long t1 = System.currentTimeMillis();
        System.out.println(ss.subsetExistsRecursion(set,setLen,sum));
        long t2 = System.currentTimeMillis();
        System.out.println(ss.subSetExistsMemTopDown(set,setLen,sum,lookup));
        long t3 = System.currentTimeMillis();

        System.out.println(t2-t1);
        System.out.println(t3-t2);

    }
}

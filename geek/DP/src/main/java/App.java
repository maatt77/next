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

    }
}

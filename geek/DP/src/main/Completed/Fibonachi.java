
import java.util.HashMap;

public class Fibonachi {
    public Fibonachi() {

    }

    public static Integer fibRecursion(Integer n ) {
        if (n<=1){
            return n;
        }
        return fibRecursion(n-1) + fibRecursion(n-2);
    }

    public HashMap<Integer,Integer> fibTopHM = new HashMap<Integer, Integer>();
    public  Integer fibMemo(Integer n ) {

//        If the key is in the map then return the value
        if(fibTopHM.containsKey(n)){
            return fibTopHM.get(n);
        }
//        If not
        if (n<=1) return n;
        Integer fibValue = fibMemo(n-1) + fibMemo(n-2);
        fibTopHM.put(n,fibValue);
        return fibValue;
    }

    public HashMap<Integer,Integer> fibBotUpHM = new HashMap<Integer, Integer>();
    public Integer fibBottomUp(Integer n ) {
        fibBotUpHM.put(0,0);
        fibBotUpHM.put(1,1);
        for (int i = 2; i <=n ; i++) {
            Integer fib = fibBotUpHM.get(i-1) + fibBotUpHM.get(i-2);
            fibBotUpHM.put(i,fib);
        }

        return fibBotUpHM.get(n);

    }
}

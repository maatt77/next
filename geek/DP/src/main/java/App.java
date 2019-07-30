import java.util.HashMap;

public class App {

    public static void main(String[] args) {

    int[] coins = {4,2,3};
    int sum = 6;

        CoinChange cc = new CoinChange();
//        System.out.println(cc.numSolsRecursion(coins,coins.length-1,sum));
//        System.out.println(cc.numSolsMemo(coins,coins.length-1,sum,new HashMap<String,Integer>()));
//        System.out.println(cc.numSolsTab(coins,sum));
//        System.out.println(cc.leastNumCoinsRecursion(coins,coins.length-1,sum));
        System.out.println(cc.leastNumCoinsTabular(coins,sum));

    }


}

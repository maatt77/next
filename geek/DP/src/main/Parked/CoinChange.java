
public class CoinChange {

    public Integer numSolutions(Integer[] change,Integer total){

//        Exit conditions
          if (total < 0 ) return 0;
//        Recursions

        Integer elementToBeExcluded = change.length-1;
        Integer countwithOutElem;
        Integer countwithOneElem;


        return 0;
    }

    static int count( int S[], int index, int total )
    {
        // If total is 0 then there is 1 solution
        // (do not include any coin)
        if (total == 0)
            return 1;

        // If total is less than 0 then no
        // solution exists
        if (total < 0)
            return 0;

        // If there are no coins and total
        // is greater than 0, then no
        // solution exist
        if (index <=0 && total >= 1)
            return 0;

        // count is sum of solutions (i)
        // including S[index-1] (ii) excluding S[index-1]
        return count( S, index - 1, total ) +
                count( S, index, total-S[index-1] );
    }
}

import java.util.Arrays;
import java.util.Map;

public class SumSubset {

//    Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
//    Example:
//
//    Input:  set[] = {3, 34, 4, 12, 5, 200}, sum = 9
//    Output:  True  //There is a subset (4, 5) with sum 9.

    /*
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 35;

        System.out.println(new SumSubset().subSetExistsMemTopDown(set,set.length,sum,new HashMap<String, Boolean>()));

        System.out.println(new SumSubset().subSetExistsTabular(set,sum));
     */

    public boolean subsetExistsRecursion( int inpSet[] ,Integer setLen, Integer sum) {

        if ( sum ==0 ) return true;
        if (( setLen == 0 && sum != 0) || sum < 0) return false;
//        if the last element is greater than the sum then ignore it
//        if(inpSet[setLen-1] > sum) return subsetExistsRecursion(inpSet,setLen-1,sum);
        boolean withoutLastElem = subsetExistsRecursion(inpSet,setLen-1,sum);
        boolean withLastElem = subsetExistsRecursion(inpSet,setLen-1,sum-inpSet[setLen-1]);
        return withoutLastElem || withLastElem;

    }

    public boolean subSetExistsMemTopDown(int inpSet[], Integer setLen, Integer sum, Map<String,Boolean> lookup) {

        if ( sum ==0 ) return true;
        if (( setLen == 0 && sum != 0) || sum < 0) return false;

        String key = setLen.toString() + "|" + sum.toString();
        boolean withoutLastElem;
        boolean withLastElem;
        if(!lookup.containsKey(key)) {
            withoutLastElem = subsetExistsRecursion(inpSet, setLen - 1, sum);
            withLastElem = subsetExistsRecursion(inpSet, setLen - 1, sum - inpSet[setLen - 1]);
            lookup.put(key,withoutLastElem || withLastElem);
        }

        return lookup.get(key);

    }

    public boolean subSetExistsTabular(int[] inpSet, int sum) {

        boolean[][] results = new boolean[inpSet.length][sum+1];

        for (int col = 0; col <= sum; col++) {

            for (int row = 0; row <= inpSet.length-1; row++) {

                if(col==0){
                    results[row][col] = true;
                } else if (row==0) {
                    results[row][col] = inpSet[row] == col? true:false ;
                } else {
                    boolean withelem = inpSet[row] > col ? false : results[row-1][col-inpSet[row]];
                    boolean withOutElem = results[row-1][col];
                    results[row][col] = withelem || withOutElem ;
                }
            }
        }

        return results[inpSet.length-1][sum];
    }
}

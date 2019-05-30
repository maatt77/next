import java.util.Map;

public class SumSubset {

//    Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
//    Example:
//
//    Input:  set[] = {3, 34, 4, 12, 5, 200}, sum = 9
//    Output:  True  //There is a subset (4, 5) with sum 9.

    public boolean subsetExistsRecursion( Integer inpSet[] ,Integer setLen, Integer sum) {

        if ( sum ==0 ) return true;
        if ( setLen == 0 && sum != 0) return false;
//        if the last element is greater than the sum then ignore it
//        if(inpSet[setLen-1] > sum) return subsetExistsRecursion(inpSet,setLen-1,sum);
        boolean withoutLastElem = subsetExistsRecursion(inpSet,setLen-1,sum);
        boolean withLastElem = subsetExistsRecursion(inpSet,setLen-1,sum-inpSet[setLen-1]);
        return withoutLastElem || withLastElem;

    }

    public boolean subSetExistsMemTopDown(Integer inpSet[], Integer setLen, Integer sum, Map<String,Boolean> lookup) {

        if ( sum ==0 ) return true;
        if ( setLen == 0 && sum != 0) return false;

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
}

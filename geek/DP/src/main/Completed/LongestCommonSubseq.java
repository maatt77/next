import java.util.Arrays;
import java.util.Map;

public class LongestCommonSubseq {

   /*
    Given two strings s1 and s2, the task is to find the length of longest common subsequence present in both of them.
    Examples:
    Input: s1 = “ABCDGH”, s2 = “AEDFHR”
    Output: 3
    LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
    Input: s1 = “striver”, s2 = “raj”
    Output: 1
    */

   /*
       String stringOne = "AABB";
    String stringTwo = "AAB";

    LongestCommonSubseq lcs = new LongestCommonSubseq();

        System.out.println(lcs.lcsTabular(stringOne,stringTwo));
        System.out.println(lcs.lcsRecursive(stringOne,stringTwo,stringOne.length(),stringTwo.length(),0));
        System.out.println(lcs.lcsRecusrsiveMemo(stringOne,stringTwo,stringOne.length(),stringTwo.length(),0,new HashMap<String,Integer>()));
    */

    public int lcsTabular(String stringOne, String stringTwo) {

        System.out.println(stringOne + "  " + stringTwo);

        int[][] results = new int[stringOne.length()][stringTwo.length()];

        results[0][0] = stringOne.charAt(0) == stringTwo.charAt(0) ? 1 : 0;

        for (int col = 1; col < stringTwo.length(); col++) {
            int currentCompare = stringOne.charAt(0) == stringTwo.charAt(col) ? 1 : 0;
            results[0][col] = Integer.max(results[0][col - 1], currentCompare);
        }

        for (int row = 1; row < stringOne.length(); row++) {
            int currentCompare = stringTwo.charAt(0) == stringOne.charAt(row) ? 1 : 0;
            results[row][0] = Integer.max(currentCompare, results[row - 1][0]);
        }

        for (int row = 1; row < stringOne.length(); row++) {
            for (int col = 1; col < stringTwo.length(); col++) {
                if (stringOne.charAt(row) == stringTwo.charAt(col)) {
                    results[row][col] = results[row - 1][col - 1] + 1;
                } else {
                    results[row][col] = Math.max(results[row - 1][col], results[row][col - 1]);
                }
            }
        }

        char[] path = new char[results[stringOne.length() - 1][stringTwo.length() - 1]];

        int row = stringOne.length()-1;
        int col = stringTwo.length()-1;
        int pathIndex = path.length-1;

        while (row > 0 && col > 0){

            if (stringOne.charAt(row) == stringTwo.charAt(col)){
                path[pathIndex] = stringOne.charAt(row);
                pathIndex--;
                row--;
                col--;
            } else {
                if( results[row][col-1] > results[row-1][col] ) {
                    col--;
                } else {
                    row--;
                }
            }
        }
        System.out.println(Arrays.toString(path));

        return results[stringOne.length() - 1][stringTwo.length() - 1];

    }



    public int lcsRecursive(String stringOne, String stringTwo, int stringOneLen, int stringTwoLen, int subLen) {

        // If the last characters are the same then take them off and call recursively

        if (stringOneLen == 0 || stringTwoLen == 0) {
            return subLen;
        }

        if (stringOne.charAt(stringOneLen - 1) == stringTwo.charAt(stringTwoLen - 1)) {
            return lcsRecursive(stringOne, stringTwo, stringOneLen - 1, stringTwoLen - 1, subLen + 1);
        } else {
            return Math.max(
                    lcsRecursive(stringOne, stringTwo, stringOneLen - 1, stringTwoLen, subLen),
                    lcsRecursive(stringOne, stringTwo, stringOneLen, stringTwoLen - 1, subLen)
            );
        }

    }

    public int lcsRecusrsiveMemo(String stringOne, String stringTwo, int stringOneLen, int stringTwoLen, int subLen, Map<String, Integer> memMap) {

        String key = stringOne.toString() + " - " + stringTwo.toString();

        if (!memMap.containsKey(key)) {
            if (stringOneLen == 0 || stringTwoLen == 0) {
                memMap.put(key, subLen);
            }

            if (stringOne.charAt(stringOneLen - 1) == stringTwo.charAt(stringTwoLen - 1)) {
                memMap.put(key, lcsRecursive(stringOne, stringTwo, stringOneLen - 1, stringTwoLen - 1, subLen + 1));
            } else {
                memMap.put(key, Math.max(
                        lcsRecursive(stringOne, stringTwo, stringOneLen - 1, stringTwoLen, subLen),
                        lcsRecursive(stringOne, stringTwo, stringOneLen, stringTwoLen - 1, subLen)
                ));
            }
        }
        return memMap.get(key);
    }

}

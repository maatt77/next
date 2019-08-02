import java.util.HashMap;
import java.util.Map;

public class Levenshtein {

//    String sOne = "abd";
//    String sTwo = "acd";
//
//    Levenshtein levin = new Levenshtein();
//
//        System.out.println( levin.levinRecursive( sOne,sTwo,sOne.length(),sTwo.length() ) );
//        System.out.println( levin.levinDPMemo( sOne,sTwo,sOne.length(),sTwo.length(),new HashMap<String,Integer>() ) );
//        System.out.println(levin.levinBotUp(sOne,sTwo));

    public int levinRecursive(String sOne, String sTwo, int lenOne, int lenTwo) {

        if (lenOne == 0 && lenTwo == 0) return 0;
        if (lenOne == 0) return lenTwo;
        if (lenTwo == 0) return lenOne;

        if (sOne.charAt(lenOne - 1) == sTwo.charAt(lenTwo - 1)) {
            return levinRecursive(sOne, sTwo, lenOne - 1, lenTwo - 1);
        }
        return Math.min(Math.min(
                levinRecursive(sOne, sTwo, lenOne - 1, lenTwo) + 1,
                levinRecursive(sOne, sTwo, lenOne, lenTwo - 1) + 1),
                levinRecursive(sOne, sTwo, lenOne - 1, lenTwo - 1) + 1
        );

    }

    public int levinDPMemo(String sOne, String sTwo, int lenOne, int lenTwo, Map<String, Integer> memTab) {

        String key = String.valueOf(lenOne) + "-" + String.valueOf(lenTwo);

        if (!memTab.containsKey(key)) {

            if (lenOne == 0 && lenTwo == 0) memTab.put(key, 0);
            if (lenOne == 0) memTab.put(key, lenTwo);
            if (lenTwo == 0) memTab.put(key, lenOne);

            if (sOne.charAt(lenOne - 1) == sTwo.charAt(lenTwo - 1)) {
                memTab.put(key, levinRecursive(sOne, sTwo, lenOne - 1, lenTwo - 1));
            } else {
            memTab.put(key, Math.min( Math.min(
                    levinRecursive(sOne, sTwo, lenOne - 1, lenTwo) + 1,
                    levinRecursive(sOne, sTwo, lenOne, lenTwo - 1) + 1),
                    levinRecursive(sOne, sTwo, lenOne - 1, lenTwo - 1) + 1
            ) ) ;}
            ;

        }

        return memTab.get(key);

    }

    public int levinBotUp(String sOne, String sTwo) {

        int[][] results = new int[sOne.length() + 1][sTwo.length() + 1];
        for (int row = 0; row <= sOne.length(); row++) {
            for (int col = 0; col <= sTwo.length(); col++) {
                if (row == 0) {
                    results[row][col] = col;
                } else if (col == 0) {
                    results[row][col] = row;
                } else {
                    if (sOne.charAt(row - 1) == sTwo.charAt(col - 1)) {
                        results[row][col] = results[row - 1][col - 1];
                    } else {
                        results[row][col] =
                                1 + Math.min(
                                        Math.min(results[row - 1][col], results[row][col - 1]),
                                        results[row - 1][col - 1]);
                    }
                }
            }
        }

        int row = sOne.length();
        int col = sTwo.length();

        while (row > 0 && col > 0) {

            if(sOne.charAt(row-1) == sTwo.charAt(col-1)) {
                row = row-1;
                col = col-1;
            } else {
                int above = results[row - 1][col];
                int left = results[row][col - 1];
                int diagonal = results[row - 1][col - 1];
                if(results[row][col]-1 == above) {
                    // Insert
                    System.out.println( "Insert  => " + sOne.charAt(row-1));
                    row--;
                } else if (results[row][col]-1 == diagonal) {
                    System.out.println("replace => " + sTwo.charAt(col-1));
                    row--;
                    col--;
                } else {
                    System.out.println("delete => " + sTwo.charAt(col-1));
                    col--;
                }
            }
        }

        return results[sOne.length()][sTwo.length()];
    }


    public int levinBotUpCap(String sOne, String sTwo,int maxDistance) {

        int[][] results = new int[sOne.length() + 1][sTwo.length() + 1];
        for (int row = 0; row <= sOne.length(); row++) {
            for (int col = 0; col <= sTwo.length(); col++) {
                if (row == 0) {
                    results[row][col] = col;
                } else if (col == 0) {
                    results[row][col] = row;
                } else {
                    if (sOne.charAt(row - 1) == sTwo.charAt(col - 1)) {
                        results[row][col] = results[row - 1][col - 1];
                    } else {
                        results[row][col] =
                                1 + Math.min(
                                        Math.min(results[row - 1][col], results[row][col - 1]),
                                        results[row - 1][col - 1]);
                    }
                }
            }
        }

        int row = sOne.length();
        int col = sTwo.length();

        while (row > 0 && col > 0) {

            if(sOne.charAt(row-1) == sTwo.charAt(col-1)) {
                row = row-1;
                col = col-1;
            } else {
                int above = results[row - 1][col];
                int left = results[row][col - 1];
                int diagonal = results[row - 1][col - 1];
                if(results[row][col]-1 == above) {
                    // Insert
                    System.out.println( "Insert  => " + sOne.charAt(row-1));
                    row--;
                } else if (results[row][col]-1 == diagonal) {
                    System.out.println("replace => " + sTwo.charAt(col-1));
                    row--;
                    col--;
                } else {
                    System.out.println("delete => " + sTwo.charAt(col-1));
                    col--;
                }
            }
        }

        return results[sOne.length()][sTwo.length()];
    }

    // using only 2 rows of the matrix , So the space complexity is O(n)s
    public int levinBotUpSpace( String sOne, String sTwo ) {

        int[][] results = new int[2][sTwo.length() + 1];
        int resultRow = 0;

        for (int row = 0; row <= sOne.length() ; row++) {
            
            int currentRow = row % 2;
            int previousRow = (row+1) % 2;

            for (int col = 0; col <=sTwo.length() ; col++) {
                if (row == 0) {
                    results[currentRow][col] = col;
                } else if (col == 0) {
                    results[currentRow][col] = row;
                } else {
                    if (sOne.charAt(row - 1) == sTwo.charAt(col - 1)) {
                        results[currentRow][col] = results[previousRow][col - 1];
                    } else {
                        results[currentRow][col] =
                                1 + Math.min(
                                        Math.min(results[previousRow][col], results[currentRow][col - 1]),
                                        results[previousRow][col - 1]);
                    }
                }

                
            }
            resultRow = currentRow;
        }
        return results[resultRow][sTwo.length()];
    }

}

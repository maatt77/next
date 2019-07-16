public class ZeroOneKnapsack {

    /*
    Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total
    value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent
    values and weights associated with n items respectively. Also given an integer W which represents knapsack
    capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller
    than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
    https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
     */

    /*
        int value[] = {10, 40, 30, 50};
        int weight[] = {5, 4, 6, 3};
        int W = 10;

        ZeroOneKnapsack knap = new ZeroOneKnapsack();

        int maxVale = knap.knapsackRecursive(value,weight,W,4);
        int maxValueTabular = knap.knapsackTabular(value,weight,W,4);

        System.out.println(maxVale);
        System.out.println(maxValueTabular);
     */

    public int knapsackRecursive(int[] values,int[] weights, int totalWeight, int len) {

        if(len==0 || totalWeight <=0)
            return 0;

        if(weights[len-1] > totalWeight){
            return knapsackRecursive(values,weights,totalWeight,len-1);
        }

        int withoutTheElem = knapsackRecursive(values,weights,totalWeight,len-1);
        int withTheElem = values[len-1] + knapsackRecursive(values,weights,totalWeight-weights[len-1],len-1);

        return Integer.max( withoutTheElem,withTheElem );

    // Time Complexity => exponential => 2^n

    }

    public int knapsackTabular(int[] values, int[] weights, int totalWeight, int len) {

        int[][] results = new int[values.length+1][totalWeight+1];

        for (int row = 0; row <= values.length; row++) {

            for (int w = 0; w <= totalWeight; w++) {

                if(w==0 || row==0) {
                    results[row][w] =0;
                }
                else if (weights[row-1] <= w){
                    results[row][w] = Integer.max( values[row-1] + results[row-1][w-weights[row-1]] , results[row-1][w] );

                }else {
                    results[row][w] = results[row-1][w];
                }
            }
        }
        knapsackPrint(results,values.length,totalWeight,values,weights);
        return results[values.length][totalWeight];
    }

    public void knapsackPrint(int[][] results , int row,int weight, int[] values, int[] weights) {

        if(row<=0 || weight <=0){
            return;
        }

        if(results[row][weight] == results[row-1][weight]){
            knapsackPrint(results,row-1,weight,values,weights);
        } else {
            System.out.println("Weigh ==> " +weights[row-1] + "   Value ==> " + values[row-1] );
            knapsackPrint(results,row-1,weight-weights[row-1],values,weights);
        }


    }


}

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        int value[] = {10, 40, 30, 50};
        int weight[] = {5, 4, 6, 3};
        int W = 10;

        ZeroOneKnapsack knap = new ZeroOneKnapsack();

        int maxVale = knap.knapsackRecursive(value,weight,W,4);
        int maxValueTabular = knap.knapsackTabular(value,weight,W,4);

        System.out.println(maxVale);
        System.out.println(maxValueTabular);
    }
}

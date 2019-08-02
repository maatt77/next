import java.util.HashMap;

public class App {

    public static void main(String[] args) {

    String sOne = "abdeee";
    String sTwo = "acdd";

    Levenshtein levin = new Levenshtein();

        System.out.println( levin.levinRecursive( sOne,sTwo,sOne.length(),sTwo.length() ) );
        System.out.println( levin.levinDPMemo( sOne,sTwo,sOne.length(),sTwo.length(),new HashMap<String,Integer>() ) );
        System.out.println(levin.levinBotUp(sOne,sTwo));
        System.out.println(levin.levinBotUpSpace(sOne,sTwo));

    }


}

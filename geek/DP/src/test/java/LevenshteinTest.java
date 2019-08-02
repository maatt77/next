import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.HashMap;

import static org.junit.Assert.*;


public class LevenshteinTest {


    String sOne;
    String sTwo;
    Levenshtein levin;
    @Before
    public void init() throws Exception {

        sOne = "abd";
        sTwo = "acd";
        levin = new Levenshtein();

    }

    @Test
    public void levinRecursive() throws Exception {
        assertEquals(1, levin.levinRecursive( sOne,sTwo,sOne.length(),sTwo.length() ) );
    }

    @Test
    public void levinDPMemo() throws Exception {
        assertEquals(1,levin.levinDPMemo( sOne,sTwo,sOne.length(),sTwo.length(),new HashMap<>() )  );
    }

    @Test
    public void levinBotUp() throws Exception {
        assertEquals(1,levin.levinBotUp(sOne,sTwo));
    }

    @Test
    public void levinBotUpCap() throws Exception {
    }

//    @Test
//    public void levinBotUpSpace() throws Exception {
//        assertEquals(1,levin.levinBotUpSpace());
//    }


}

import com.mycompany.hackernewsuutiset.Uutinen;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class UutinenTest {
    
    public UutinenTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testaaToString(){
        Uutinen uutinen = new Uutinen("Otsikko", "Pihla", "urli");
        assertEquals(uutinen.toString(), "Otsikko by Pihla, url: urli");
    }
}

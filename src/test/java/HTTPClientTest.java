
import com.mycompany.hackernewsuutiset.HTTPClient;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(HTTPClient.class)
public class HTTPClientTest {

    public HTTPClientTest() {
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

    @Test(expected = RuntimeException.class)
    public void invalidUrl() {
        new HTTPClient().callURL("invalidurl");
    }

    @Test
    public void testCallUrl() {
        String tulos = new HTTPClient().callURL("http://ptoivanen.users.paivola.fi/juuh.html");
        System.out.println("TULOS: " + tulos);
        String oletettu = "<html>\n"
                + "Vastaus\n"
                + "</html>\n";
        assertEquals(tulos, oletettu);

    }

}

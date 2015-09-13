

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import com.mycompany.hackernewsuutiset.HTTPClient;
import com.mycompany.hackernewsuutiset.HackerPaivanUutiset;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

public class HackerPaivanUutisetTest {

    static HackerPaivanUutiset hakija = new HackerPaivanUutiset("http://127.0.0.1:8080");
    static HTTPClient client = new HTTPClient();
    
    @Rule
    public static WireMockRule wireMockRule = new WireMockRule(8080);

    public HackerPaivanUutisetTest() {
    }

    @BeforeClass
    public static void setUpClass() {

        wireMockRule.stubFor(get(urlEqualTo("/v0/topstories.json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("[100, 101]")));
        
         wireMockRule.stubFor(get(urlEqualTo("/v0/newstories.json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("[100, 101]")));
         
         wireMockRule.stubFor(get(urlMatching("/v0/item.*"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("{\n"
         + "  \"by\" : \"pc\",\n"
         + "  \"descendants\" : 0,\n"
         + "  \"id\" : 100,\n"
         + "  \"kids\" : [ 454529, 152 ],\n"
         + "  \"score\" : 6,\n"
         + "  \"time\" : 1171910288,\n"
         + "  \"title\" : \"SpikeSource, CA-based startup, becomes Ubuntu commercial support provider for US\",\n"
         + "  \"type\" : \"story\",\n"
         + "  \"url\" : \"http://www.linux-watch.com/news/NS7616991195.html\"\n"
         + "}")));

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
    public void testaaSuosituinUutinen() {
        String s = hakija.haeSuosituinUutinen();
        System.out.println("s: " + s);
        assertEquals(s, "Suosituin uutinen on SpikeSource, CA-based startup, becomes Ubuntu commercial support provider for US by pc, url: http://www.linux-watch.com/news/NS7616991195.html");
    }

    @Test
    public void testaaViimeisinUutinen() {
        String s = hakija.haeViimeisinUutinen();
        assertEquals(s, "Viimeisin uutinen on SpikeSource, CA-based startup, becomes Ubuntu commercial support provider for US by pc, url: http://www.linux-watch.com/news/NS7616991195.html");
    }

    @Test
    public void testaaKonstruktori() {
        HackerPaivanUutiset uutiset = new HackerPaivanUutiset();
    }
}

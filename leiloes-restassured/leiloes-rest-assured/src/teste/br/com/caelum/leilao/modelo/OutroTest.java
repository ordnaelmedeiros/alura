package teste.br.com.caelum.leilao.modelo;

import static com.jayway.restassured.RestAssured.expect;

import org.junit.Test;

public class OutroTest {
	
	@Test
    public void deveGerarUmCookie() {
        expect()
            .cookie("rest-assured", "funciona")
        .when()
            .get("/cookie/teste");
    }
	
	@Test
    public void deveGerarUmHeader() {
        expect()
            .header("novo-header", "abc")
        .when()
            .get("/cookie/teste");
    }
	
}

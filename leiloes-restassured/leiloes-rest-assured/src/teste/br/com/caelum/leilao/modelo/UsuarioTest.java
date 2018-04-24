package teste.br.com.caelum.leilao.modelo;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;

import br.com.caelum.leilao.modelo.Leilao;
import br.com.caelum.leilao.modelo.Usuario;

public class UsuarioTest {

	private Usuario mauricio;
	private Usuario guilerme;

	@Before
	public void before() {
		
		mauricio = new Usuario(1L, "Mauricio Aniche", "mauricio.aniche@caelum.com.br");
		guilerme = new Usuario(2L, "Guilherme Silveira", "guilherme.silveira@caelum.com.br");
		
	}
	
	@Test
	public void deveRetornarListaDeUsuarios() {
		
		
		XmlPath path = 
			given()
                .header("Accept", "application/xml")
                .get("/usuarios")
                .andReturn().xmlPath();
		
		List<Usuario> usuariosRetorno = path.getList("list.usuario", Usuario.class);
		
		List<Usuario> usuariosEsperados = Arrays.asList(mauricio, guilerme);

		assertEquals(usuariosEsperados, usuariosRetorno);
		
	}
	
	@Test
    public void deveRetornarUsuarioPeloId() {
		
        JsonPath path = given()
            .header("Accept", "application/json")
            .parameter("usuario.id", 1)
            .get("/usuarios/show")
            .andReturn()
            .jsonPath();

        Usuario usuario = path.getObject("usuario", Usuario.class);
        
        assertEquals(mauricio, usuario);

    }
	
	@Test
    public void deveRetornarLeilaoPeloId() {
		
        JsonPath path = given()
            .header("Accept", "application/json")
            .parameter("leilao.id", 1)
            .get("/leiloes/show")
            .andReturn()
            .jsonPath();

        Leilao leilao = path.getObject("leilao", Leilao.class);
        
        Leilao esperado = new Leilao(1l, "Geladeira", 800.0, mauricio, false);

        assertEquals(esperado, leilao);

    }
	
	@Test
    public void deveRetornarTotalDeLeiloes() {
		
        XmlPath path = given()
            .header("Accept", "application/xml")
            .get("/leiloes/total")
            .andReturn()
            .xmlPath();

        int total = path.getInt("int");
        
        assertEquals(2, total);

    }
	
	@Test
	public void deveAdicionarUmUsuario() {
		
		Usuario joao = new Usuario("Joao da Silva", "joao@dasilva.com");

		XmlPath retorno = given()
			.header("Accept", "application/xml")
			.contentType("application/xml")
			.body(joao)
			.expect()
			.statusCode(200)
		.when()
			.post("/usuarios")
			.andReturn()
			.xmlPath();

		Usuario resposta = retorno.getObject("usuario", Usuario.class);

		assertEquals("Joao da Silva", resposta.getNome());
		assertEquals("joao@dasilva.com", resposta.getEmail());
		
		//System.out.println(resposta.getId());
		
		given()
			.header("Accept", "application/xml")
			.contentType("application/xml")
			.body(joao)
			.expect()
			.statusCode(200)
		.when()
			.delete("/usuarios/deleta")
			.asString();

	}
	
	@Test
	public void deveAdicionarUmLeilao() {

		Leilao leilao = new Leilao(null, "Moto G", 200.0, mauricio, true);
		
		XmlPath retorno = given()
				.header("Accept", "application/xml")
				.contentType("application/xml")
				.body(leilao)
				.expect()
				.statusCode(200)
			.when()
				.post("/leiloes")
				.andReturn()
				.xmlPath();
		
		
		Leilao resposta = retorno.getObject("leilao", Leilao.class);

		assertEquals("Moto G", resposta.getNome());
		
		given()
			.header("Accept", "application/xml")
			.contentType("application/xml")
			.body(leilao)
			.expect()
			.statusCode(200)
		.when()
			.delete("/leiloes/deletar");
		
		
	}
	
}

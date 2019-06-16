package br.ia.israel;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class OlaMundoTest {
	
	@Test
	public void testOlaMundo() {
		Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");
		Assert.assertTrue(response.body().asString().equals("Ola Mundo!"));
		Assert.assertTrue(response.statusCode() == 200);
		
		ValidatableResponse validacao = response.then();
		validacao.statusCode(200);
	}

	@Test
	public void devoConhecerOutrasFormasRestAssured() {
		given()
			//Pré-Condicoes
		.when()
			//Verbos HTTP
			.get("http://restapi.wcaquino.me/ola")
		.then()
			//Verificacoes/Assertivas
			.statusCode(200);
	}
	
	@Test
	public void deveConhecerMathersHamcrest() {
		assertThat("Maria", Matchers.is("Maria"));
		assertThat(128, Matchers.is(128));
		assertThat(128, Matchers.isA(Integer.class));
		assertThat(128d, Matchers.isA(Double.class));
		assertThat(128d, Matchers.greaterThan(120d));
		assertThat(128d, Matchers.lessThan(130d));
		
		List<Integer> impares = Arrays.asList(1,3,5,7,9);
		assertThat(impares, hasSize(5));
		assertThat(impares, contains(1,3,5,7,9));
		assertThat(impares, containsInAnyOrder(1,3,5,7,9));
		assertThat(impares, hasItem(1));
		assertThat(impares, hasItems(1,5));
		
		assertThat("Maria", is(not("João")));
		assertThat("Maria", not("João"));
		assertThat("Maria", anyOf(is("Maria"), is("Joaquina")));
		assertThat("Israel", allOf(startsWith("Is"), endsWith("el"), containsString("rael")));
	}
	
	@Test
	public void devoValidarBody() {
		given()
			//Pré-Condicoes
		.when()
			//Verbos HTTP
			.get("http://restapi.wcaquino.me/ola")
		.then()
			//Verificacoes/Assertivas
			.statusCode(200)
			.body(is("Ola Mundo!"))
			.body(containsString("Mundo"))
			.body(is(not(nullValue())));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package q3;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViaCepAPITest {

    @Test
    public void testValidCep() {
        String cep = "01001000";
        Response response = RestAssured.given()
                .baseUri("https://viacep.com.br/ws")
                .basePath("/{cep}/json/")
                .pathParam("cep", cep)
                .when()
                .get();

        assertEquals(200, response.getStatusCode());
        assertTrue(response.jsonPath().getString("cep").matches("\\d{5}-\\d{3}"));
    }

    @Test
    public void testInvalidCep() {
        String cep = "12345ABCD";
        Response response = RestAssured.given()
                .baseUri("https://viacep.com.br/ws")
                .basePath("/{cep}/json/")
                .pathParam("cep", cep)
                .when()
                .get();

        assertEquals(400, response.getStatusCode());
    }

    @Test
    public void testValidAddress() {
        String uf = "SP";
        String city = "São Paulo";
        String logradouro = "Avenida Paulista";
        Response response = RestAssured.given()
                .baseUri("https://viacep.com.br/ws")
                .basePath("/{uf}/{city}/{logradouro}/json/")
                .pathParam("uf", uf)
                .pathParam("city", city)
                .pathParam("logradouro", logradouro)
                .when()
                .get();

        assertEquals(200, response.getStatusCode());
        assertTrue(response.jsonPath().getString("logradouro").contains("Avenida Paulista"));
    }
}
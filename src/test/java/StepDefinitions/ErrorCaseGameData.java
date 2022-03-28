package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ErrorCaseGameData {
    RequestSpecification request;
    Response response;
    @Given("que configuro las cabeceras para ejecutar la siguiente solicitud {string}")
    public void que_configuro_las_cabeceras_para_ejecutar_la_siguiente_solicitud(String host, io.cucumber.datatable.DataTable dataTable) {
        RestAssured.baseURI=host;
        request = RestAssured.given();
        List<Map<String, String>> listHeader = dataTable.asMaps(String.class, String.class);
        request.header(listHeader.get(0).get("parametros"), listHeader.get(0).get("valor"));


    }
    @When("ejecuto la solicitud get con el siguiente path {string} y param")
    public void ejecuto_la_solicitud_get_con_el_siguiente_path_y_param(String path, io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> paramValues= dataTable.asMap(String.class, String.class);
        String _nomParam=paramValues.get("nomParam");
        String _valParam=paramValues.get("valParam");
        response=request.when()
                .get(path);


    }
    @When("ejecuto la solicitud get con este path {string} agregando otro param")
    public void ejecuto_la_solicitud_get_con_este_path_agregando_otro_param(String path, io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> paramValues= dataTable.asMap(String.class, String.class);
        String _nomParam=paramValues.get("nombreparamentro");
        String _valParam=paramValues.get("valor");
        response=request.when()
                .get(path);
        System.out.println(path);

    }
    @Then("valido status code con un valor de {int}")
    public void valido_status_code_con_un_valor_de(Integer status) {

        response.then()
                .log().all()
                .statusCode(status);

    }



}

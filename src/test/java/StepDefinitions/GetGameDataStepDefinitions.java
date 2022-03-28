package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetGameDataStepDefinitions {
    RequestSpecification request;
    Response response;
    /************************************ GET CUSTOMER METHOD **********************/
    @Given("que configuro las cabeceras para ejecutar la solicitud {string}")
    public void que_configuro_las_cabeceras_para_ejecutar_la_solicitud(String host, DataTable dataTable) {
        RestAssured.baseURI=host;
        request = RestAssured.given();
        List<Map<String, String>> listHeader = dataTable.asMaps(String.class, String.class);
        request.header(listHeader.get(0).get("parametros"), listHeader.get(0).get("valor"));
    }

    @When("ejecuto la solicitud get con path {string} y param")
    public void ejecuto_la_solicitud_get_con_path_y_param(String path, DataTable dataTable) {
        Map<String, String> paramValues= dataTable.asMap(String.class, String.class);
        String _nomParam=paramValues.get("nomParam");
        String _valParam=paramValues.get("valParam");
        response=request.when()
                .log().all()
                .get(path);
    }
    @When("ejecuto la solicitud get con path {string} agregando otro param")
    public void ejecuto_la_solicitud_get_con_path_agregando_otro_param(String path, DataTable dataTable) {
        Map<String, String> paramValues= dataTable.asMap(String.class, String.class);
        String _nomParam=paramValues.get("nombreparamentro");
        String _valParam=paramValues.get("valor");
        response=request.when()
                .get(path);
        System.out.println(path);
    }

    @Then("valido status code con valor {int}")
    public void valido_status_code_con_valor(Integer status) {
        response.then()
                .statusCode(status);


    }

        @Then("obtengo el item con valor {string} de la respuesta e imprimo el id y title")
    public void obtengo_el_item_con_valor_de_la_respuesta_e_imprimo_el_id_y_title(String item) {

            String title = response.jsonPath().getString("title[1]");
            String id = response.jsonPath().getString("id[1]");
            System.out.println("******************** TITLE VALUE  : " + title + "******************** TITLE VALUE  : " + id );
    }



}

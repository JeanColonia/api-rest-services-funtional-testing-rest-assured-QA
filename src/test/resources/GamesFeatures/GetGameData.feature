Feature: Test GET Customers work method
  @Escenario1
  Scenario: consulta de usuario get con error
    Given que configuro las cabeceras para ejecutar la solicitud "https://www.freetogame.com/"
      |parametros  |valor            |
      |Content-Type|application/json |
    When ejecuto la solicitud get con path "api/games" y param
      | nomParam | platform |
      | valParam | pc       |
    And ejecuto la solicitud get con path "api/games" agregando otro param
      | nombreparamentro | category |
      | valor            | shooter  |
    Then valido status code con valor 200
    And obtengo el item con valor "2" de la respuesta e imprimo el id y title

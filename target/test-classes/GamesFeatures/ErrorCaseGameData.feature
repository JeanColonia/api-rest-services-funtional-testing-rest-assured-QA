Feature: Test GET Customers work method
  @Escenario2
  Scenario: consulta de usuario get con estado de error
    Given que configuro las cabeceras para ejecutar la siguiente solicitud "https://www.freetogame.com/"
      |parametros  |valor            |
      |Content-Type|application/json |
    When ejecuto la solicitud get con el siguiente path "api/games" y param
      | nomParam | platform |
      | valParam | pc       |
    And ejecuto la solicitud get con este path "api/games" agregando otro param
      | nombreparamentro | category |
      | valor            | shooter  |
    Then valido status code con un valor de 400
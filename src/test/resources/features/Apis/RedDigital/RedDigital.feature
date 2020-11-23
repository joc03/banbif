Feature: Consumo de API Red Digital

  @REDDIGITAL @API-RECAUDACIONES @PAGAR-SERVICIOS @Consultar
  Scenario Outline: Pagar Servicio

    Given  quiero ejecutar el API Red Digital  con la peticion "<caso_prueba>"
    When   gennero el token para ejecutarlo en el API "<caso_prueba>"
    And    consumo el api con la data de prueba "<caso_prueba>"
    Then   verifico el status code "<caso_prueba>"
    And    las respuestas esperadas en las rutas "<caso_prueba>" del response

    Examples:
      |caso_prueba|
      |1          |
      |5          |




  @REDDIGITAL @API-RECAUDACIONES @CONVENIOS

  Scenario Outline: Consultar  Convenio
    Given  quiero ejecutar el API Red Digital  con la peticion "<caso_prueba>"
    When   gennero el token para ejecutarlo en el API "<caso_prueba>"
    And    consumo el api con la data de prueba "<caso_prueba>"
    Then   verifico el status code "<caso_prueba>"
    And    las respuestas esperadas en las rutas "<caso_prueba>" del response

    Examples:
      |caso_prueba |
      |49          |
      |52          |



  @REDDIGITAL @API-RECAUDACIONES @CONVENIOS

  Scenario Outline: Lista Detallada Convenio
    Given  quiero ejecutar el API Red Digital  con la peticion "<caso_prueba>"
    When   gennero el token para ejecutarlo en el API "<caso_prueba>"
    And    consumo el api con la data de prueba "<caso_prueba>"
    Then   verifico el status code "<caso_prueba>"
    And    las respuestas esperadas en las rutas "<caso_prueba>" del response

    Examples:
      |caso_prueba|
      |53         |
      |60         |

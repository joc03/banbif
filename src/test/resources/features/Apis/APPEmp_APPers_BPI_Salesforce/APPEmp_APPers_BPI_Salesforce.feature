Feature: Consumo de API

  @Agentes @Consultar

  Scenario Outline: Solicitud de Consultas

    Given  quiero ejecutar el API APPEmp_APPers_BPI_SALESFORCE  con la peticion "<caso_prueba>"
    When   gennero el token para ejecutarlo en el API "<caso_prueba>"
    And    consumo el api con la data de prueba "<caso_prueba>"
    Then   verifico el status code "<caso_prueba>"
    And    las respuestas esperadas en las rutas "<caso_prueba>" del response

    Examples:
      |caso_prueba|
      |1          |
      |2          |

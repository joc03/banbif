Feature: Consumo de API

  @Agentes @Consultar

  Scenario Outline: Consultar Productos

    Given  quiero ejecutar el API AppBpi  con la peticion "<caso_prueba>"
    When   gennero el token para ejecutarlo en el API "<caso_prueba>"
    And    consumo el api con la data de prueba "<caso_prueba>"
    Then   verifico el status code "<caso_prueba>"
    And    las respuestas esperadas en las rutas "<caso_prueba>" del response

    Examples:
      |caso_prueba|
      |1          |
      |2          |
      |3          |
      |4          |
      |5          |
      |6          |
      |7          |
      |8          |
      |9          |
      |10         |
      |11         |
      |12         |
      |13         |
      |14         |
      |15         |
      |16         |
      |17         |
      |18         |
      |19         |
      |20         |
      |21         |
      |22         |



